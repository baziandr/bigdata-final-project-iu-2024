#!/bin/bash

password=$(head -n 1 scripts/secrets/.hive.pass)

echo "=== PUTTING AVSC FILES TO HDFS ==="
hdfs dfs -mkdir -p project/warehouse/avsc
hdfs dfs -put output/*.avsc project/warehouse/avsc
echo ""

echo "=== CREATE DATABASE AND EXTERNAL PARTITIONED AND BUCKETING TABLE ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/db.hql > output/hive_results.txt
echo ""

echo "=== PERFORM QUERY 1 ==="
hdfs dfs -rmr project/hive/warehouse/q1
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q1.hql
echo "count" > output/q1.csv
hdfs dfs -cat project/output/q1/* >> output/q1.csv
echo ""

echo "=== PERFORM QUERY 2 ==="
hdfs dfs -rmr project/hive/warehouse/q2
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q2.hql
echo "avg_price" > output/q2.csv
hdfs dfs -cat project/output/q2/* >> output/q2.csv
echo ""

echo "=== PERFORM QUERY 3 ==="
hdfs dfs -rmr project/hive/warehouse/q3
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q3.hql
echo "avg_name_len" > output/q3.csv
hdfs dfs -cat project/output/q3/* >> output/q3.csv
echo ""

echo "=== PERFORM QUERY 4 ==="
hdfs dfs -rmr project/hive/warehouse/q4
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q4.hql
echo "avg_desc_len" > output/q4.csv
hdfs dfs -cat project/output/q4/* >> output/q4.csv
echo ""

echo "=== PERFORM QUERY 5 ==="
hdfs dfs -rmr project/hive/warehouse/q5
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q5.hql
echo "suplicates_cnt" > output/q5.csv
hdfs dfs -cat project/output/q5/* >> output/q5.csv
echo ""

echo "=== PERFORM QUERY 6 ==="
hdfs dfs -rmr project/hive/warehouse/q6
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q6.hql
echo "duplicates_ratio" > output/q6.csv
hdfs dfs -cat project/output/q6/* >> output/q6.csv
echo ""

echo "=== PERFORM QUERY 7 ==="
hdfs dfs -rmr project/hive/warehouse/q7
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q7.hql
echo "category, average_price" > output/q7.csv
hdfs dfs -cat project/output/q7/* >> output/q7.csv
echo ""

echo "=== PERFORM QUERY 8 ==="
hdfs dfs -rmr project/hive/warehouse/q8
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q8.hql
echo "percentage_unique" > output/q8.csv
hdfs dfs -cat project/output/q8/* >> output/q8.csv
echo ""

echo "=== PERFORM QUERY 9 ==="
hdfs dfs -rmr project/hive/warehouse/q9
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q9.hql
echo "cnt" > output/q9.csv
hdfs dfs -cat project/output/q9/* >> output/q9.csv
echo ""

echo "=== PERFORM QUERY 10 ==="
hdfs dfs -rmr project/hive/warehouse/q10
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q10.hql
echo "duplicate_count" > output/q10.csv
hdfs dfs -cat project/output/q10/* >> output/q10.csv
echo ""

echo "=== PERFORM QUERY 11 ==="
hdfs dfs -rmr project/hive/warehouse/q11
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q11.hql
echo "duplicates_percentage" > output/q11.csv
hdfs dfs -cat project/output/q11/* >> output/q11.csv
echo ""

echo "=== PERFORM QUERY 12 ==="
hdfs dfs -rmr project/hive/warehouse/q12
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q12.hql
echo "cnt" > output/q12.csv
hdfs dfs -cat project/output/q12/* >> output/q12.csv
echo ""

echo "=== PERFORM QUERY 13 ==="
hdfs dfs -rmr project/hive/warehouse/q13
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/q13.hql
echo "category" > output/q13.csv
hdfs dfs -cat project/output/q13/* >> output/q13.csv
echo ""