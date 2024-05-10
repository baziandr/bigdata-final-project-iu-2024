USE team6_projectdb;

DROP TABLE IF EXISTS model1_predictions;
CREATE EXTERNAL TABLE model1_predictions(
    category_indexed DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/output/model1_predictions'; 