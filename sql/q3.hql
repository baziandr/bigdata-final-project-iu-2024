USE team6_projectdb;

DROP TABLE IF EXISTS q3_results;
CREATE EXTERNAL TABLE q3_results(avg_name_len FLOAT)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q3'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q3_results
SELECT AVG(CHAR_LENGTH(item_name)) AS avg_name_len
FROM items;

INSERT OVERWRITE DIRECTORY 'project/output/q3' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q3_results;
