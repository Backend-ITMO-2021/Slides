Array(1, 2, 3, 4, 5).map(i => i * 2)
// val res0: Array[Int] = Array(2, 4, 6, 8, 10)

Array(1, 2, 3, 4, 5).filter(i => i % 2 == 1)
// val res1: Array[Int] = Array(1, 3, 5)

Array(1, 2, 3, 4, 5).take(2)
// val res2: Array[Int] = Array(1, 2)

Array(1, 2, 3, 4, 5).drop(2)
// val res3: Array[Int] = Array(3, 4, 5)

Array(1, 2, 3, 4, 5).slice(1, 4)
// val res4: Array[Int] = Array(2, 3, 4)

Array(1, 2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 8).distinct
// val res5: Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8)

val a = Array(1, 2, 3, 4, 5)
val a2 = a.map(x => x + 10)
// val a2: Array[Int] = Array(11, 12, 13, 14, 15)

a(0)
// val res6: Int = 1

a2(0)
// val res7: Int = 11
