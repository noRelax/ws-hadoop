package com.relax.www.mr;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;


public class WordCount {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("mapreduce.client.submit.file.replication", "1");
		System.setProperty("hadoop.home.dir", "G:/dev/bigdata/hadoop/hadoop-2.4.1");
		Job job = Job.getInstance(conf);
		
		//notice
		job.setJarByClass(WordCount.class);
		
		//set mapper`s property
		job.setMapperClass(WCMapper.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		FileInputFormat.setInputPaths(job, new Path("hdfs://hadoop01:9000/input/"));
		//set reducer`s property
		job.setReducerClass(WCReducer.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		FileOutputFormat.setOutputPath(job, new Path("hdfs://hadoop01:9000/output3/"));
		
		//submit
		job.waitForCompletion(true);
	}

}
