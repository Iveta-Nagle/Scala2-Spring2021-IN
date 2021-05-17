package com.github.ivetan

import scala.collection.mutable.ArrayBuffer

object Crush extends App {

  //https://www.hackerrank.com/challenges/crush/problem

  val folderName = "./src/resources"
  val filePaths = Utilities.getFileNames(folderName, prefix = "crush", suffix = "xt")
  filePaths.foreach(println)

  def getColumn(lines: Array[String], columnIndex: Int): Array[Int] = {
    val cols = lines.map(line => line.split(" ").map(_.trim))
    val columnArray = cols.tail.map(line => line(columnIndex).toInt)
    columnArray
  }

  def getArrayMaxValue(filePath: String): Long = {
    val lines = Utilities.getLinesFromFile(filePath)
    val nrOfElements = lines(0).split(" ").toSeq.head.toInt
    val numbOfOperations = lines(0).split(" ").toSeq.last.toInt

    val myArray = ArrayBuffer.fill(nrOfElements)(0)

    val startIndexes = getColumn(lines, 0)
    val endIndexes = getColumn(lines, 1)
    val valuesToAdd = getColumn(lines, 2)

    var max = 0

    for (n <- 0 until numbOfOperations) {
      for (i <- startIndexes(n) - 1 until endIndexes(n)) {
        myArray.update(i, myArray(i) + valuesToAdd(n))
        if (myArray(i) > max) max = myArray(i)
      }
    }
    max
  }

  def printResult(max: Long, filePath: String): Unit = {
    println(s"Max value after manipulations from file $filePath is $max")
  }

  filePaths.foreach(filePath => printResult(getArrayMaxValue(filePath), filePath))

}
