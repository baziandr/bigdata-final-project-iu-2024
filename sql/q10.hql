USE team6_projectdb;

DROP TABLE IF EXISTS q10_results;
CREATE EXTERNAL TABLE q10_results(
    duplicate_count INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
location 'project/hive/warehouse/q10'; 

-- to not display table names with column names
SET hive.resultset.use.unique.column.names = false;

INSERT INTO q10_results
SELECT COUNT(*) as duplicate_count
FROM (
  SELECT itemid, shopid, item_name, item_description, item_variation, price, stock, category, cb_option, is_preferred, sold_count, item_creation_date
  FROM items
  GROUP BY itemid, shopid, item_name, item_description, item_variation, price, stock, category, cb_option, is_preferred, sold_count, item_creation_date
  HAVING COUNT(*) > 1
) as duplicates;

INSERT OVERWRITE DIRECTORY 'project/output/q10' 
ROW FORMAT DELIMITED FIELDS 
TERMINATED BY ',' 
SELECT * FROM q10_results;
