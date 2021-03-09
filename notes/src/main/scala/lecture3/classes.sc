class Foo(x: Int) {
  def printMsg(msg: String) = {
    println(msg + x)
  }
}
val f = new Foo(1)
f.printMsg("hello")
//f.x

class Bar(val x: Int) {
  def printMsg(msg: String) = {
    println(msg + x)
  }
}
val b = new Bar(1)
b.x

class Qux(var x: Int) {
  def printMsg(msg: String) = {
    x += 1
    println(msg + x)
  }
}
val q = new Qux(1)
q.printMsg("hello")
q.printMsg("hello")
q.x

class Baz(x: Int) {
  val bangs = "!" * x
  def printMsg(msg: String) = {
    println(msg + bangs)
  }
}
val z = new Baz(3)
z.printMsg("hello")

