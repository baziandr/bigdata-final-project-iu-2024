USE team6_projectdb;

DROP TABLE IF EXISTS q9_results;
CREATE EXTERNAL TABLE q9_results(
    cnt INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q9'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q9_results
SELECT COUNT(DISTINCT item_description) AS unique_descriptions
FROM items
GROUP BY item_name
HAVING COUNT(DISTINCT item_description) > 1;

INSERT OVERWRITE DIRECTORY 'project/output/q9' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q9_results;
