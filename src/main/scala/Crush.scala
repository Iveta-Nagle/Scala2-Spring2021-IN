import com.github.ivetan.Utilities

object Crush extends App {
  //TODO Solve the following problem
  //https://www.hackerrank.com/challenges/crush/problem
  //TODO read and parse ../resources/crush1.txt
  //TODO read and parse ../resources/crush2.txt
  //you need to perform 3 operations
  //and find the maximum in the new array

  //think how well this would work on large values of operations like
  //1000 1000

  val filePath = "./src/resources/crush1.txt"
  val lines = Utilities.getLinesFromFile(filePath)
  val numbOfZeros = lines(0).split(" ").toSeq.head.toInt
  val numbOfOperations = lines(0).split(" ").toSeq.last.toInt
  println(numbOfZeros)
  println(numbOfOperations)
  val array0 = (1 to numbOfZeros).map(n => 0)
  array0.foreach(print)

  println()
  val array1Data = lines(1).split(" ").toIndexedSeq
  val array1Start = array1Data(0).toInt
  val array1End = array1Data(1).toInt
  val array1Sum = array1Data(2).toInt

  val array1 = array0.map(n => if (array0.indexOf(n)+1<array1Start) 0 else n+100 )
  array1.foreach(println)
  //  println(array1Start)
  //  println(array1End)
  //val array1 = array0.map
  //  val array1 = (1 to numbOfZeros).map(n => ).toSeq
  //  val stringEnd = numbOfString+1
  //  val strings = lines.slice(1, stringEnd)
  //  val queries = lines.slice(stringEnd+1, lines.length)

}