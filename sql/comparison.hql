USE team6_projectdb;

DROP TABLE IF EXISTS comparison;
CREATE EXTERNAL TABLE comparison(
    model STRING,
    f1_score DOUBLE
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/output/evaluation'; 