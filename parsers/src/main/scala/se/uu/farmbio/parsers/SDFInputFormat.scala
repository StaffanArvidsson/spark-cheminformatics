package se.uu.farmbio.parsers

import org.apache.hadoop.io.LongWritable
import org.apache.hadoop.io.Text
import org.apache.hadoop.mapred.FileSplit
import org.apache.hadoop.mapred.InputSplit
import org.apache.hadoop.mapred.JobConf
import org.apache.hadoop.mapred.RecordReader
import org.apache.hadoop.mapred.Reporter
import org.apache.hadoop.mapred.FileInputFormat

class SDFInputFormat extends FileInputFormat[LongWritable,Text] {
  
  def getRecordReader(split:InputSplit,job:JobConf,reporter:Reporter) : RecordReader[LongWritable,Text] = {
    reporter.setStatus(split.toString())
    new SDFRecordReader(split.asInstanceOf[FileSplit],job)
  }
  
}