package com.hadoop.join;
import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.input.FileSplit;

public class JoinMapper extends Mapper<LongWritable>,Text,Text,Text>{
	public static final String LEFT_FILENAME="student_info.txt";
	public static final String RIGHT_FILENAME="student_class_info.txt";
	public static final String LEFT_FILENAME_FLAG="l";
	public static final String RIGHT_FILENAME_FLAG="r";

	protected void map(LongWritable key,Text value,Context context) throw IOException,
	InterruptedException{
		String filePath=((FileSplit) context.getInputSplit()).getPath().toString();
		String fileFlag=null;
		String joinKey=null;
		String joinValue=null;

		if(filePath.contains(LEFT_FILENAME)){
			fileFlag=LEFT_FILENAME_FLAG;
			joinKey=value.toString().split("\t")[1];
			joinValue=value.toString().split("\t")[0];
		}else if(filePath.contains(RIGHT_FILENAME)){
			fileFlag=RIGHT_FILENAME_FLAG;
			joinKey=value.toString().split("\t")[0];
			joinValue=vlaue.toString().split("\t")[1];
		}
		else{}
		context.write(new Text(joinKey),new Text(joinValue+"\t"+fileFlag));
	}
}