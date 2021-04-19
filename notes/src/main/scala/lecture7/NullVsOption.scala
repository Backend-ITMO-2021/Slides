package lecture7

object NullVsOption extends App {
  def toIntJava(s: String): Int = {
    try {
      Integer.parseInt(s.trim)
    } catch {
      case e: Exception => 0
    }
  }

  def toInt(s: String): Option[Int] = {
    try {
      Some(Integer.parseInt(s.trim))
    } catch {
      case e: Exception => None
    }
  }

  val extract = (x: String) => toInt(x) match {
    case Some(i) => println(i)
    case None => println("That didn't work.")
  }

  val stringA = "1"
  val stringB = "2"
  val stringC = "3"
  val y = for {
    a <- toInt(stringA)
    b <- toInt(stringB)
    c <- toInt(stringC)
  } yield a + b + c

  toInt("1").foreach(println)
  toInt("x").foreach(println)
}
