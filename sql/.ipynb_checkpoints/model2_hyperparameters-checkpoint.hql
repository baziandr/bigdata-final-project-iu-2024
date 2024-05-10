USE team6_projectdb;

DROP TABLE IF EXISTS model2_hyperparameters;
CREATE EXTERNAL TABLE model2_hyperparameters(
    parameter STRING,
    value DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/output/model2_hyperparameters'; 