#!/bin/bash

password=$(head -n 1 scripts/secrets/.psql.pass)

echo "=== DOWNLOADING DATA ==="
url="https://disk.yandex.ru/d/4fjdZ4Lges5_vA"
wget "$(yadisk-direct $url)" -O data/data.zip
echo ""

echo "=== UNPACKING DATA ==="
unzip data/data.zip -d data/
rm data/data.zip
mv data/Test_Pandas.csv data/original_data.csv
echo ""

echo "=== BUILDING PROJECT DB ==="
python3 scripts/build_projectdb.py
echo ""

echo "=== LISTING ALL DATABASES WITH SQOOP ==="
sqoop list-databases --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team6_projectdb --username team6 --password $password
echo ""

echo "=== LISTING ALL TABLES WITH SQOOP ==="
sqoop list-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team6_projectdb --username team6 --password $password
echo ""

echo "=== IMPORTING ALL TABLES WITH SQOOP ==="
hdfs dfs -rm -r project/warehouse
sqoop import-all-tables --connect jdbc:postgresql://hadoop-04.uni.innopolis.ru/team6_projectdb --username team6 --password $password --compression-codec=snappy --compress --as-avrodatafile --warehouse-dir=project/warehouse --m 1
echo ""

echo "=== MOVING avsc AND java FILES OT output FOLDER ==="
mv *.avsc output/
mv *.java output/
ls output/
echo ""

echo "DONE"
echo ""

