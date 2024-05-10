-- Create a hive database like team6_projectdb in project/hive/warehouse and access it.
DROP DATABASE IF EXISTS team6_projectdb CASCADE;
CREATE DATABASE team6_projectdb LOCATION "project/hive/warehouse";
USE team6_projectdb;


-- Create external Hive tables for the tables that are imported to HDFS in stage 1.
CREATE EXTERNAL TABLE items_unpart(
    itemid INT,
    shopid INT,
    item_name STRING,
    item_description STRING,
    item_variation STRING,
    price FLOAT,
    stock INT,
    category STRING,
    cb_option BOOLEAN,
    is_preferred BOOLEAN,
    sold_count INT,
    item_creation_date TIMESTAMP
)
STORED AS AVRO LOCATION 'project/warehouse/items'
TBLPROPERTIES ('avro.schema.url'='project/warehouse/avsc/items.avsc');


-- Check the datatypes of the columns of the new tables
SELECT * FROM items_unpart LIMIT 2;


-- Create external, partitioned and bucketing Hive table
CREATE EXTERNAL TABLE items (
    itemid INT,
    shopid INT,
    item_name STRING,
    item_description STRING,
    item_variation STRING,
    price FLOAT,
    stock INT,
    cb_option BOOLEAN,
    is_preferred BOOLEAN,
    sold_count INT,
    item_creation_date TIMESTAMP
)
PARTITIONED BY (category STRING)
CLUSTERED BY (is_preferred) INTO 2 BUCKETS
STORED AS AVRO
LOCATION 'project/warehouse/items'
TBLPROPERTIES ('AVRO.COMPRESS'='SNAPPY');

SET hive.exec.dynamic.partition=true;
SET hive.exec.dynamic.partition.mode=nonstrict;

INSERT INTO items
PARTITION (category)
SELECT 
    itemid,
    shopid,
    item_name,
    item_description,
    item_variation,
    price,
    stock,
    cb_option,
    is_preferred,
    sold_count,
    item_creation_date,
    category
FROM items_unpart;


-- Check whether you can query data from the tables above.
SELECT * FROM items LIMIT 2;


-- Delete the unpartitioned Hive tables from your database and
-- for the EDA use only partititioned and bucketing Hive tables.
DROP TABLE IF EXISTS items_unpart;
