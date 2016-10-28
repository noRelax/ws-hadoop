package com.relax.www.mr;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/** 
① 在执行Reducer任务之前，有一个shuffle的过程对多个mapper任务的输出进行合并、排序，输出[K2, {V2, ...}]。
② 调用reduce()方法，将[K2, {V2, ...}]作为参数传入。在reducer()方法中封装了数据汇总的逻辑，对输入的key、value进行汇总处理。
③ reduce()方法的输出被保存到指定的目录下。
* @ClassName: WCReducer 
* @Description: TODO(Reducer任务) 
* @author no_relax 
* @date 2016年10月28日 下午3:16:40 
*  
*/
public class WCReducer extends Reducer<Text, LongWritable, Text, LongWritable>{

	@Override
	protected void reduce(Text key, Iterable<LongWritable> values, Context context)
			throws IOException, InterruptedException {
		//define a counter
		long counter = 0;
		//loop
		for(LongWritable l : values){
			counter += l.get();
		}
		//write
		context.write(key, new LongWritable(counter));
	}
	

}
