USE team6_projectdb;

DROP TABLE IF EXISTS q1_results;
CREATE EXTERNAL TABLE q1_results(count INT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q1'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q1_results
SELECT COUNT(DISTINCT category)
FROM items;

INSERT OVERWRITE DIRECTORY 'project/output/q1' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q1_results;
