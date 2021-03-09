var total = 0
for (i <- Range(0, 10)) {
  if (i % 2 == 0) total += i
  else total += 2
}
total

var total = 0
for (i <- Range(0, 10)) {
  // total += i % 2 == 0 ? i : 2
  total += (if (i % 2 == 0) i else 2)
}
total