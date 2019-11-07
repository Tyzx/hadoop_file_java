package com.hellohadoop;
import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class IntSumReducer extends Reducer<Text,IntWritable,Text,IntWritable>{
	private IntWirtable result=new IntWritable();
	public void reduce(Text key,Iterable<IntWritable> values, Context context){
		int sum=0;
		for(IntWritable vla:values){
			sum+=val.get();
		}
		result.set(sum);
		context.write(key,result);
	}
}