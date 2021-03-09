var total = 0
val items = Array(1, 10, 100, 1000)
for (item <- items) total += item
total

var total = 0
for (i <- Range(0, 5)) {
  println("Looping " + i)
  total = total + i
}
total


val multi = Array(
  Array(1, 2, 3), Array(4, 5, 6)
)
for (
  arr <- multi;
  i <- arr
) print(i + " ")
for {
  arr <- multi
  i <- arr
  if i % 2 == 0
} print(i + " ")