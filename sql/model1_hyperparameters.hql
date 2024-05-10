USE team6_projectdb;

DROP TABLE IF EXISTS model1_hyperparameters;
CREATE EXTERNAL TABLE model1_hyperparameters(
    parameter STRING,
    value DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/output/model1_hyperparameters'; 