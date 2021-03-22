val s = Set(1, 2, 3)
// s: Set[Int] = Set(1, 2, 3)

s.contains(2)
// res51: Boolean = true

s.contains(4)
// res52: Boolean = false

Set(1, 2, 3) + 4 + 5
// res53: Set[Int] = HashSet(5, 1, 2, 3, 4)

Set(1, 2, 3) - 2
// res54: Set[Int] = Set(1, 3)

Set(1, 2, 3) ++ Set(2, 3, 4)
// res55: Set[Int] = Set(1, 2, 3, 4)

for (i <- Set(1, 2, 3, 4, 5)) print(i + " ")
// 5 1 2 3 4
