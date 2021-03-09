val g: Int => Int = i => i + 1
g(10)
val g2 = (i: Int) => i * 2
g2(10)

val sum: Int => Int => Int =
  a => b => a + b
sum(1)(2)

val composition:
  (Int => Int) =>
    (Int => Int => Int) =>
      Int => Int => Int =
  fun => fun2 => a => b =>
    fun2(fun(a))(fun(b))

composition(g2)(sum)(1)(2)