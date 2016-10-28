package com.relax.www.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/** 
① 读取输入文件内容（可以来自于本地文件系统，或HDFS文件系统等），对输入文件的每一行，解析成key-value对[K1,V1]。K1表示行起始偏移量，V1表示读取的一行内容。
② 调用map()方法，将[K1,V1]作为参数传入。在map()方法中封装了数据处理的逻辑，对输入的key、value进行处理。
③ map()方法处理的结果也用key-value的方式进行输出，记为[K2, V2]。
* @ClassName: WCMapper 
* @Description: TODO(Mapper任务) 
* @author no_relax 
* @date 2016年10月28日 下午3:13:21 
*  
*/
public class WCMapper extends Mapper<LongWritable, Text, Text, LongWritable>{

	@Override
	protected void map(LongWritable key, Text value, Context context)
			throws IOException, InterruptedException {
		//accept
		String line = value.toString();
		//split
		String[] words = line.split(" ");
		//loop
		for(String w : words){
			//send
			context.write(new Text(w), new LongWritable(1));
		}
	}

	
	
	

}
