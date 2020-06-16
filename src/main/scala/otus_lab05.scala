
import scala.io.Source

object otus_lab05 extends App {
  val fileName = "files\\SAT__College_Board__2010_School_Level_Results.csv"
  val sourceArray = Source.fromFile(fileName, "UTF-8").getLines.toArray

  println("Critical Reading Mean : " + sourceArray.foldLeft(0){ (m: Int, n: String) => compute(m, n, 3)  }/(sourceArray.length-1))
  println("Mathematics Mean : " + sourceArray.foldLeft(0){ (m: Int, n: String) => compute(m, n, 4)  }/(sourceArray.length-1))
  println("Writing Mean : " + sourceArray.foldLeft(0){ (m: Int, n: String) => compute(m, n, 5)  }/(sourceArray.length-1))
  def compute (acc: Int, str: String, pos: Int) :Int = {
    try {
      str.split(",")(pos).toInt
    } catch {
      case e: ArrayIndexOutOfBoundsException => return acc
      case e: NumberFormatException => return acc
    }
    acc + str.split(",")(pos).toInt

  }
}

