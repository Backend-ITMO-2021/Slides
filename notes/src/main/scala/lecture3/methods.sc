
def printHello(times: Int) = {
  println("hello " + times)
}
printHello(1)
printHello(times = 2)
//printHello("1")

def printHello2(times: Int = 0) = {
  println("hello " + times)
}
printHello2(1)
printHello2()

def hello(i: Int = 0) = {
  "hello " + i
}
hello(1)
println(hello())
val helloHello = hello(123) +
  " " + hello(456)
helloHello.reverse