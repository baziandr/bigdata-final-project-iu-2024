USE team6_projectdb;

DROP TABLE IF EXISTS q12_results;
CREATE EXTERNAL TABLE q12_results(
    cnt INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q12'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q12_results
SELECT COUNT(*) 
FROM items 
WHERE category = '#N/A';

INSERT OVERWRITE DIRECTORY 'project/output/q12' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q12_results;
