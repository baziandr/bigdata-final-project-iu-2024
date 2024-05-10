#!/bin/bash

echo "=== CREATING HIVE TABLE FOR MODEL 1 HYPERPARAMETERS ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/model1_hyperparameters.hql
echo ""

echo "=== CREATING HIVE TABLE FOR MODEL 2 HYPERPARAMETERS ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/model2_hyperparameters.hql
echo ""

echo "=== CREATING HIVE TABLE FOR MODEL 1 PREDICTIONS ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/model1_predictions.hql
echo ""

echo "=== CREATING HIVE TABLE FOR MODEL 2 PREDICTIONS ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/model2_predictions.hql
echo ""

echo "=== CREATING HIVE TABLE FOR COMPARISON OF TWO MODELS ==="
beeline -u jdbc:hive2://hadoop-03.uni.innopolis.ru:10001 -n team6 -p $password -f sql/comparison.hql
echo ""

echo "Done"
