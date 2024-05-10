USE team6_projectdb;

DROP TABLE IF EXISTS q13_results;
CREATE EXTERNAL TABLE q13_results(
    category STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q13'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q13_results
SELECT DISTINCT category
FROM items;

INSERT OVERWRITE DIRECTORY 'project/output/q13' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q13_results;
