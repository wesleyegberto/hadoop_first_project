
./hadoop-2.7.0/bin/hdfs dfs -rm /output/*
./hadoop-2.7.0/bin/hdfs dfs -rmdir /output



echo "Running Hadoop Job WordCounter"
./hadoop-2.7.0/bin/hadoop jar WordCounter-Hadoop/dist/HadoopWordCount.jar /input/ /output


echo ''
echo 'Job Input'
./hadoop-2.7.0/bin/hdfs dfs -ls  /input

echo ''
echo 'Job Output'
./hadoop-2.7.0/bin/hdfs dfs -ls /output

