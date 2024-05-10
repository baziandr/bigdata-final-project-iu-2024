USE team6_projectdb;

DROP TABLE IF EXISTS q2_results;
CREATE EXTERNAL TABLE q2_results(avg_price FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q2'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q2_results
SELECT AVG(price) AS avg_price
FROM items;

INSERT OVERWRITE DIRECTORY 'project/output/q2' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q2_results;
