USE team6_projectdb;

DROP TABLE IF EXISTS model2_predictions;
CREATE EXTERNAL TABLE model2_predictions(
    category_indexed DOUBLE,
    prediction DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/output/model2_predictions'; 