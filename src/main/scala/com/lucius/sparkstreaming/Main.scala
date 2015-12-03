package com.lucius.sparkstreaming

import org.apache.spark.SparkConf
import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.{StreamingContext, Seconds}

object Main {
  /**
   * 从TCP Socket中读取数据
   */
  def readFromTCPSocket(ssc: StreamingContext) = {
    ssc.socketTextStream("localhost", 9999, StorageLevel.MEMORY_AND_DISK_SER)
  }

  //从目录中读取文件
  def readFromFiles(ssc: StreamingContext) = {
    ssc.textFileStream("hdfs://appcluster/lucius")
  }

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local[2]").setAppName("NetWorkWordCount")
    val ssc = new StreamingContext(conf, Seconds(5)) //每个JVM中只有一个StreamingContext
    //val lines = readFromTCPSocket(ssc: StreamingContext)
    val lines = readFromFiles(ssc)

    val words = lines.flatMap(_.split(" "))
    val wordCounts = words.map(x => (x, 1)).reduceByKey(_ + _)
    wordCounts.print()
    ssc.start()
    ssc.awaitTermination()
  }
}
