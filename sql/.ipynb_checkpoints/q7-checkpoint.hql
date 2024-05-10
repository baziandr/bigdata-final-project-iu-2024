USE team6_projectdb;

DROP TABLE IF EXISTS q7_results;
CREATE EXTERNAL TABLE q7_results(
    category STRING,
    average_price FLOAT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q7'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q7_results
SELECT category, AVG(price) AS average_price
FROM items
GROUP BY category;

INSERT OVERWRITE DIRECTORY 'project/output/q7' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q7_results;
