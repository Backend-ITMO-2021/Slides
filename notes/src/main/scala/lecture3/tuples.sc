
val t: (Int, Boolean, String) =
  (1, true, "hello")
t._1
t._2
t._3

val (a, b, c) = t
a
b
c

val t2 = (1, true, "hello", 'c', 0.2, 0.5f, 12345678912345L)
t2._7 + t2._6 * t2._4 / t2._1

