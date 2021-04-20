import scala.annotation.tailrec

val f = (x: Int) => x + 2
val df = (f: Int => Int) => (x: Int) => f(f(x))
df(f)(2)

def succ: Int => Int = _ + 1
def pred: Int => Int = _ - 1
def sum: (Int, Int) => Int = (a, b) =>
  if (b < 1) a
  else sum(succ(a), pred(b))
sum(5, 2)

var i = 0
var sum = 0
while (i < 100) {
  i = i + 1
  sum = sum + i
}

@tailrec
def loop(i: Int, sum: Int, limit: Int): Int =
  if (i < limit) i
  else loop(i + 1, i + sum, limit)

//println(List(2 + 1, 3 * 2, 1 / 0, 5 - 4).length)

