USE team6_projectdb;

DROP TABLE IF EXISTS q8_results;
CREATE EXTERNAL TABLE q8_results(
    percentage_unique FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q8'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q8_results
SELECT
  COUNT(DISTINCT item_description) / COUNT(item_description) AS percentage_unique
FROM 
  items;

INSERT OVERWRITE DIRECTORY 'project/output/q8' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q8_results;
