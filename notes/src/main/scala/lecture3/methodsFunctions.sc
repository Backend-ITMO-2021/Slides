class Box(var x: Int) {
  def update(f: Int => Int) =
    x = f(x)
  def printMsg(msg: String) =
    println(msg + x)
}

val b = new Box(1)
b.printMsg("Hello")
b.update(i => i + 5)
b.printMsg("Hello")
b.update(_ + 5)
b.printMsg("Hello")

val sum: (Int, Int) => Int =
  (x, y) => x + y
sum(1, 2)
val sum2: (Int, Int) => Int =
  _ + _
sum2(2, 3)

def increment(i: Int) = i + 1
val b = new Box(123)
b.update(increment)
b.update(x => increment(x))
b.update { x => increment(x) }
b.update(increment(_))
b.printMsg("result: ")

def myLoop(start: Int, end: Int)
  (callback: Int => Unit) = {
  for (i <- Range(start, end)) {
    callback(i)
  }
}

myLoop(start = 5, end = 10) { i =>
  println(s"i has value $i")
}

