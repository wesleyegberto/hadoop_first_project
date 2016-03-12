package com.primacy.hadoop;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reporter;

public class WordCountMapper extends MapReduceBase implements
		Mapper<LongWritable, Text, Text, IntWritable> {
	private final IntWritable one = new IntWritable(1);
	private Text word = new Text();

	@Override
	public void map(LongWritable key, Text value, OutputCollector<Text, IntWritable> output, Reporter reporter)
			throws IOException {
		
		String line = value.toString();
        StringTokenizer tokens = new StringTokenizer(line);
        
        while(tokens.hasMoreTokens()) {        	
	    	String text = tokens.nextToken().replaceAll("([\\.,\\[\\]\\(\\):;<>\\*\\?!_-[\"]])+", "").toLowerCase();
	    	
			word.set(text);
			output.collect(word, one);
        }
	}
}
