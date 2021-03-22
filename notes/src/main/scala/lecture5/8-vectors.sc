val v = Vector(1, 2, 3, 4, 5)
// v: Vector[Int] = Vector(1, 2, 3, 4, 5)
v(0)
// res42: Int = 1
val v2 = v.updated(2, 10)
// v2: Vector[Int] = Vector(1, 2, 10, 4, 5)
v2
// res44: Vector[Int] = Vector(1, 2, 10, 4, 5)
v
// res45: Vector[Int] = Vector(1, 2, 3, 4, 5)
val v = Vector[Int]()
// v: Vector[Int] = Vector()
val v1 = v :+ 1
// v1: Vector[Int] = Vector(1)
val v2 = 4 +: v1
// v2: Vector[Int] = Vector(4, 1)
val v3 = v2.tail
// v3: Vector[Int] = Vector(1)

val v1 = Vector(1, 2, 0, 9,  7, 2, 9, 6,???, ???,  3, 2, 5, 5,  4, 8, 4, 6)

val v2 = v1.updated(4, 8)
// val v1 = Vector(1, 2, 0, 9,  8, 2, 9, 6,???, ???,  3, 2, 5, 5,  4, 8, 4, 6)