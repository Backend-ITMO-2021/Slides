val a = Array[Int](1, 2, 3, 4)
a(0)
a(3)

val a2 = Array[String](
  "one", "two", "three", "four"
)
a2(1)

val a = new Array[Int](4)
a(0) = 1
a(2) = 100
a

val multi = Array(
  Array(1, 2), Array(3, 4)
)
multi(0)(0)
multi(0)(1)
multi(1)(0)
multi(1)(1)

