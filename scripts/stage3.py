""" Stage 3 main script """

from pyspark.sql import SparkSession
from pyspark.ml import Pipeline
from pyspark.ml.feature import Tokenizer
from pyspark.ml.feature import Word2Vec
from pyspark.ml.feature import StringIndexer
from pyspark.ml.feature import VectorAssembler
from pyspark.ml.classification import LogisticRegression
from pyspark.ml.classification import DecisionTreeClassifier
from pyspark.ml.evaluation import MulticlassClassificationEvaluator
from pyspark.ml.tuning import ParamGridBuilder
from pyspark.ml.tuning import CrossValidator
from pyspark.sql.types import StructType, StructField, StringType, DoubleType

from pyspark.sql.functions import year, month, dayofmonth, hour, minute
from scripts.TimeEncoderTransformer import TimeEncoderTransformer
from scripts.run_command import run


print("=== STARTING SPARK SESSION ===")

# Add here your team number teamx
TEAM = 6

# location of your Hive database in HDFS
WAREHOUSE = "project/hive/warehouse"

spark = SparkSession.builder\
        .appName(f"{TEAM} - spark ML")\
        .master("yarn")\
        .config("hive.metastore.uris", "thrift://hadoop-02.uni.innopolis.ru:9883")\
        .config("spark.sql.warehouse.dir", WAREHOUSE)\
        .config("spark.sql.avro.compression.codec", "snappy")\
        .config("spark.yarn.queue", "master_teams")\
        .config("spark.executor.instances", "10")\
        .config("spark.executor.cores", "10")\
        .enableHiveSupport()\
        .getOrCreate()

print("Done")

print("=== READING ITEMS TABLE FROM HIVE ===")

items = spark.read.format("avro").table('team6_projectdb.items')
items.createOrReplaceTempView('items')

print("Done")


print("=== RUNNING FEATURE EXTRACTION ===")

print("--> Vectorize item description")

INPUT_COL = "item_description"
TOKENS_COL = "desc_tokens"
OUTPUT_COL = "desc_enc"

pipeline = Pipeline(stages=[
    Tokenizer(
        inputCol=INPUT_COL,
        outputCol=TOKENS_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

pipeline = Pipeline(stages=[
    Word2Vec(
        vectorSize=5,
        seed=42,
        minCount=10,
        inputCol=TOKENS_COL,
        outputCol=OUTPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(TOKENS_COL)


print("--> Vectorize item variation")

INPUT_COL = "item_variation"
TOKENS_COL = "var_tokens"
OUTPUT_COL = "var_enc"

pipeline = Pipeline(stages=[
    Tokenizer(
        inputCol=INPUT_COL,
        outputCol=TOKENS_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

pipeline = Pipeline(stages=[
    Word2Vec(
        vectorSize=5,
        seed=42,
        minCount=1,
        inputCol=TOKENS_COL,
        outputCol=OUTPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(TOKENS_COL)

print("--> Vectorize item name")

INPUT_COL = "item_name"
TOKENS_COL = "name_tokens"
OUTPUT_COL = "name_enc"

pipeline = Pipeline(stages=[
    Tokenizer(
        inputCol=INPUT_COL,
        outputCol=TOKENS_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

pipeline = Pipeline(stages=[
    Word2Vec(
        vectorSize=5,
        seed=42,
        minCount=1,
        inputCol=TOKENS_COL,
        outputCol=OUTPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(TOKENS_COL)

print("--> Encode timestamp")

# there is no sense in "seconds" column because it is always zero
items = items.withColumn("year", year("item_creation_date")) \
        .withColumn("month", month("item_creation_date")) \
        .withColumn("day", dayofmonth("item_creation_date")) \
        .withColumn("hour", hour("item_creation_date")) \
        .withColumn("minute", minute("item_creation_date")) \
        .drop("item_creation_date")

INPUT_COL = "month"

pipeline = Pipeline(stages=[
    TimeEncoderTransformer(
        input_col=INPUT_COL,
        output_col_sin=f"{INPUT_COL}_sin",
        output_col_cos=f"{INPUT_COL}_cos",
        timestamp_part=INPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

INPUT_COL = "day"

pipeline = Pipeline(stages=[
    TimeEncoderTransformer(
        input_col=INPUT_COL,
        output_col_sin=f"{INPUT_COL}_sin",
        output_col_cos=f"{INPUT_COL}_cos",
        timestamp_part=INPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

INPUT_COL = "hour"

pipeline = Pipeline(stages=[
    TimeEncoderTransformer(
        input_col=INPUT_COL,
        output_col_sin=f"{INPUT_COL}_sin",
        output_col_cos=f"{INPUT_COL}_cos",
        timestamp_part=INPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

INPUT_COL = "minute"

pipeline = Pipeline(stages=[
    TimeEncoderTransformer(
        input_col=INPUT_COL,
        output_col_sin=f"{INPUT_COL}_sin",
        output_col_cos=f"{INPUT_COL}_cos",
        timestamp_part=INPUT_COL
    )
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

print("--> Encode category")

INPUT_COL = "category"

pipeline = Pipeline(stages=[
    StringIndexer(
        inputCol=INPUT_COL,
        outputCol=f"{INPUT_COL}_indexed")
])

items = pipeline.fit(items)\
            .transform(items)\
            .drop(INPUT_COL)

print("--> Assemble features")

inputCols = [
    'itemid',
    'shopid',
    'price',
    'stock',
    'cb_option',
    'is_preferred',
    'sold_count',
    'year',
    'month_sin',
    'month_cos',
    'day_sin',
    'day_cos',
    'hour_sin',
    'hour_cos',
    'minute_sin',
    'minute_cos',
    'name_enc',
    'desc_enc',
    'var_enc'
]


pipeline = Pipeline(stages=[
    VectorAssembler(
        inputCols=inputCols,
        outputCol="features"
    )
])

items = pipeline.fit(items).transform(items)

for col in inputCols:
    items = items.drop(col)

print("Done")

print("=== SPLITTING DATA INTO TRAIN AND TEST DATASETS ===")

(train_data, test_data) = items.randomSplit([0.8, 0.2], seed=10)

train_data.select("features", "category_indexed")\
    .repartition(4)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/train")

# Run it from root directory of the repository
run("hdfs dfs -get project/data/train/*.json data/train")

test_data.select("features", "category_indexed")\
    .repartition(4)\
    .write\
    .mode("overwrite")\
    .format("json")\
    .save("project/data/test")

# Run it from root directory of the repository
run("hdfs dfs -get project/data/test/*.json data/test")

print("=== BUILDING MODEL 1: LOGISTIC REGRESSION ===")

print("--> Building and training")

lr = LogisticRegression(labelCol="category_indexed", featuresCol="features")
model = lr.fit(train_data)

print("--> Getting testing predictions")

# Make predictions on the test set
predictions = model.transform(test_data)

print("--> Model evaluation")

# Evaluate the model using F1-score
evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)
f1_score_1 = evaluator.evaluate(predictions)
print(f"Test set F1-score: {f1_score_1}")

print("--> Running grid search")


paramGrid = ParamGridBuilder() \
    .addGrid(lr.regParam, [0.0, 0.5, 1.0]) \
    .addGrid(lr.elasticNetParam, [0.0, 0.5, 1.0]) \
    .build()

evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)


# Create the CrossValidator
cv = CrossValidator(
    estimator=lr,
    estimatorParamMaps=paramGrid,
    evaluator=evaluator,
    numFolds=3
)

# Fit the model using cross-validation on the training data
cvModel = cv.fit(train_data)

print("--> Selecting best model")

# Get the best model
bestModel = cvModel.bestModel

print("--> Saving model")

bestModel.write().overwrite().save("project/models/model1")

run("hdfs dfs -get project/models/model1 models/model1")

print("--> Getting testing predctions of the best model")

# Make predictions on the test set
predictions = bestModel.transform(test_data)

print("--> Saving prediction results")

predictions.select("category_indexed", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .save("project/output/model1_predictions")

run("hdfs dfs -get project/output/model1_predictions/* output/")

print("--> Best model evaluation")

# Make predictions on the test set
predictions = bestModel.transform(test_data)

# Evaluate the model using F1-score
evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)
f1_score_1 = evaluator.evaluate(predictions)
print(f"Test set F1-score: {f1_score_1}")

print("Done")

print("=== BUILDING MODEL 2: DECISION TREE ===")

print("--> Building and training")

dt = DecisionTreeClassifier(labelCol="category_indexed", featuresCol="features")
model = dt.fit(train_data)

print("--> Getting testing predictions")

# Make predictions on the test set
predictions = model.transform(test_data)

print("--> Model evaluation")

# Evaluate the model using F1-score
evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)
f1_score_2 = evaluator.evaluate(predictions)
print(f"Test set F1-score: {f1_score_2}")

print("--> Running grid search")

paramGrid = ParamGridBuilder() \
    .addGrid(dt.maxDepth, [2, 5, 10]) \
    .addGrid(dt.minInfoGain, [0.0, 0.01, 0.1]) \
    .build()

evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)

# Create the CrossValidator
cv = CrossValidator(
    estimator=lr,
    estimatorParamMaps=paramGrid,
    evaluator=evaluator,
    numFolds=3
)

# Fit the model using cross-validation on the training data
cvModel = cv.fit(train_data)

print("--> Selecting best model")

# Get the best model
bestModel = cvModel.bestModel

print("--> Saving model")

bestModel.write().overwrite().save("project/models/model2")

run("hdfs dfs -get project/models/model2 models/model2")

print("--> Getting testing predctions of the best model")

# Make predictions on the test set
predictions = bestModel.transform(test_data)

print("--> Saving prediction results")

predictions.select("category_indexed", "prediction")\
    .coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .save("project/output/model2_predictions")

run("hdfs dfs -get project/output/model1_predictions/* output/")

print("--> Best model evaluation")

# Make predictions on the test set
predictions = bestModel.transform(test_data)

# Evaluate the model using F1-score
evaluator = MulticlassClassificationEvaluator(
    labelCol="category_indexed",
    predictionCol="prediction",
    metricName="f1"
)
f1_score_2 = evaluator.evaluate(predictions)
print(f"Test set F1-score: {f1_score_2}")

print("Done")

print("=== SAVING MODELS METRICS ===")

schema = StructType([
    StructField("model", StringType(), False),
    StructField("f1_score", DoubleType(), False)
])

data = [
    ("Logistic Regression", f1_score_1),
    ("Decision Tree", f1_score_2)
]

df = spark.createDataFrame(data, schema)

df.coalesce(1)\
    .write\
    .mode("overwrite")\
    .format("csv")\
    .save("project/output/evaluation")

run("hdfs dfs -get project/output/evaluation/* output/")
