USE team6_projectdb;

DROP TABLE IF EXISTS q5_results;
CREATE EXTERNAL TABLE q5_results(
    duplicates_cnt INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q5'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q5_results
SELECT COUNT(*) as duplicates_cnt
FROM items
GROUP BY item_description
HAVING COUNT(*) > 1;

INSERT OVERWRITE DIRECTORY 'project/output/q5' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q5_results;
