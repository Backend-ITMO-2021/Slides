Array(1, 2, 3, 4, 5, 6, 7).mkString(",")
// res21: String = "1,2,3,4,5,6,7"

Array(1, 2, 3, 4, 5, 6, 7).mkString("[", ",", "]")
// res22: String = "[1,2,3,4,5,6,7]"

Array(1, 2, 3, 4, 5, 6, 7).foldLeft(0)((x, y) => x + y)
// res23: Int = 28

Array(1, 2, 3, 4, 5, 6, 7).foldLeft(1)((x, y) => x * y)
// res24: Int = 5040

Array(1, 2, 3, 4, 5, 6, 7).foldLeft(1)(_ * _)
// res25: Int = 5040

{
  var total = 0
  for (i <- Array(1, 2, 3, 4, 5, 6, 7)) total += i
  total
}
// total: Int = 28

val grouped = Array(1, 2, 3, 4, 5, 6, 7).groupBy(_ % 2)
// grouped: Map[Int, Array[Int]] = Map(0 -> Array(2, 4, 6), 1 -> Array(1, 3, 5, 7))

grouped(0)
// res26: Array[Int] = Array(2, 4, 6)

grouped(1)
// res27: Array[Int] = Array(1, 3, 5, 7)