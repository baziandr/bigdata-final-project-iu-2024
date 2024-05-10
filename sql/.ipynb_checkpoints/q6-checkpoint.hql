USE team6_projectdb;

DROP TABLE IF EXISTS q6_results;
CREATE EXTERNAL TABLE q6_results(
    duplicate_ratio FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q6'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q6_results
SELECT 
  SUM(duplicates_num) / (SELECT COUNT(*) FROM items) AS duplicate_ratio
FROM (
    SELECT 
      COUNT(item_description) AS duplicates_num
    FROM 
      items
    GROUP BY 
      item_description
    HAVING 
      COUNT(item_description) > 1
) AS duplicates;

INSERT OVERWRITE DIRECTORY 'project/output/q6' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q6_results;
