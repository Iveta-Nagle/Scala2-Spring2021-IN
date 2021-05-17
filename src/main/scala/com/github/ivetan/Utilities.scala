package com.github.ivetan

import java.io.File

import scala.io.Source

object Utilities {


  /**
   *
   * @param srcPath source Path
   * @param encoding default UTF8
   * @return Array of String Lines
   */
  def getLinesFromFile(srcPath: String, encoding:String="UTF8"): Array[String] = {
    val bufferedSource = Source.fromFile(srcPath, enc=encoding)
    val lines = bufferedSource.getLines().toArray
    bufferedSource.close
    lines
  }

  def saveString(text: String, destPath: String): Unit = {
    import java.io.{File, PrintWriter}
    val pw = new PrintWriter(new File(destPath))
    pw.write(text)
    pw.close()
  }

  def saveLines(lines: Seq[String], destPath: String, sep: String = "\n"): Unit = {
    val txt = lines.mkString(sep)

    import java.io.{File, PrintWriter}
    val pw = new PrintWriter(new File(destPath))
    pw.write(txt)
    pw.close()
  }

  def getFileNames(folder:String, prefix:String="", suffix:String =".txt"): Array[String] = {
    val d = new File(folder)
    if (d.exists && d.isDirectory) {
      d.listFiles
        .filter(_.isFile)
        .map(_.toString)
        .filter(_.split("/").last.startsWith(prefix)) //windows specific escaping for file paths \\
        .filter(_.endsWith(suffix))
    } else {
      Array[String]()
    }
  }

}
