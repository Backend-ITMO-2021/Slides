val b = Array.newBuilder[Int]
b += 1
b += 2
b.result()

Array.fill(5)("hello")
/* val res3: Array[String] =
  Array(hello, hello, hello, hello, hello) */
Array.tabulate(5)(n => s"hello $n")
/* val res4: Array[String] =
  Array(hello 0, hello 1, hello 2, hello 3, hello 4)*/
Array(1, 2, 3) ++ Array(4, 5, 6)
/* val res5: Array[Int] =
  Array(1, 2, 3, 4, 5, 6)*/