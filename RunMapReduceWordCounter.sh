

cd WordCounter-MapReduce

echo "Running Mapper"
java Mapper /home/wesley/Downloads/Hadoop-Project/ebook.txt

echo "Running Reducer"
java Reducer

