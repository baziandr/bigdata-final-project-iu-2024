USE team6_projectdb;

DROP TABLE IF EXISTS q11_results;
CREATE EXTERNAL TABLE q11_results(
    duplicate_percentage FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q11'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q11_results
SELECT COUNT(*) / (SELECT COUNT(*) FROM items) as duplicate_percentage
FROM (
  SELECT item_name, item_description
  FROM items
  GROUP BY item_name, item_description
  HAVING COUNT(*) > 1
) as duplicates;

INSERT OVERWRITE DIRECTORY 'project/output/q11' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q11_results;
