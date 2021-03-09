val a = Array(1, 2, 3, 4)
val a2 = for (i <- a)
  yield i * i
val a3 = for (i <- a)
  yield "hello " + i
val a4 = for (
  i <- a
  if i % 2 == 0
) yield "hello " + i

val a2 = Array(1, 2)
val b = Array("hello", "world")
val flattened = for {
  i <- a
  s <- b
} yield s + i
/*val flattened: Array[String] =
Array(hello1, world1, hello2, world2,
hello3, world3, hello4, world4)*/
val flattened2 = for {
  s <- b
  i <- a
} yield s + i
/*val flattened2: Array[String] = Array(
hello1, hello2, hello3, hello4,
world1, world2, world3, world4)
*/
val fizzbuzz = for (i <- Range.inclusive(1, 100)) yield {
  if (i % 3 == 0 && i % 5 == 0) "FizzBuzz"
  else if (i % 3 == 0) "Fizz"
  else if (i % 5 == 0) "Buzz"
  else i.toString
}
/*val fizzbuzz: IndexedSeq[String] = Vector(
1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz, 16, 17, Fizz, 19, Buzz, Fizz, 22, 23, Fizz, Buzz, 26, Fizz, 28, 29, FizzBuzz, 31, 32, Fizz, 34, Buzz, Fizz, 37, 38, Fizz, Buzz, 41, Fizz, 43, 44, FizzBuzz, 46, 47, Fizz, 49, Buzz, Fizz, 52, 53, Fizz, Buzz, 56, Fizz, 58, 59, FizzBuzz, 61, 62, Fizz, 64, Buzz, Fizz, 67, 68, Fizz, Buzz, 71, Fizz, 73, 74, FizzBuzz, 76, 77, Fizz, 79, Buzz, Fizz, 82, 83, Fizz, Buzz, 86, Fizz, 88, 89, FizzBuzz, 91, 92, Fizz, 94, Buzz, Fizz, 97, 98, Fizz, Buzz)*/