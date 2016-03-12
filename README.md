#Hadoop
######

Projeto de um trabalho sobre Hadoop.


## Libs ##
hadoop-common-2.7.0.jar
hadoop-mapreduce-client-core-2.7.0.jar
hadoop-test-1.2.1.jar
slf4j-api-1.7.7.jar


## Prática ##
Ebook em TXT para os testes: http://www.gutenberg.org/cache/epub/4300/pg4300.txt


MapReduce: Pega o arquivo, divide em linhas e envia para cada worker efetuar o processamento delas. Assim temos um Map de
	linha-processo. Onde cada worker retornará um Map de palavra-quantidade, assim ao final, basta efetuarmos toda a junção dos Maps.
	É efetuado em dois passos: Mapper onde é efetuado a distribuição das linhas para o processamento em cada nó e Reduce onde
	é efetuado a totalização dos resultados (podendo ordernar, filtrar, agregar, etc).
	
	Ex:
	Map de entrada: <linha, conteúdo>
	Map de saída: <palavra, quantidade> ou <palavra, 1>
	Maps agregados: <palavra, lista(1, 1, 1)> ou <palavra, list(4, 2, 3)>



## Links ##
http://www.javaworld.com/article/2158789/data-storage/know-this-right-now-about-hadoop.html
http://hadoop.apache.org/docs/current/hadoop-project-dist/hadoop-hdfs/HdfsUserGuide.html
http://www.ibm.com/developerworks/br/data/library/techarticle/dm-1209hadoopbigdata/
http://michaelnielsen.org/blog/write-your-first-mapreduce-program-in-20-minutes/

http://blog.concretesolutions.com.br/2012/11/mapreduce-%E2%80%93-parte-i/
http://blog.concretesolutions.com.br/2012/12/hadoop-parte-i/

http://glebche.appspot.com/static/hadoop-ecosystem/hadoop-hive-tutorial.html#hadoop-installation-mac-osx
http://glebche.appspot.com/static/hadoop-ecosystem/mapreduce-job-java.html

http://bigdatahandler.com/hadoop-hdfs/installing-single-node-hadoop-2-2-0-on-ubuntu/

