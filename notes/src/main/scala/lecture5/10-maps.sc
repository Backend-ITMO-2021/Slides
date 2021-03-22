val m = Map("one" -> 1, "two" -> 2, "three" -> 3)
// m: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

m.contains("two")
// res58: Boolean = true
m("two")
// res59: Int = 2
m.get("one")
// res60: Option[Int] = Some(1)
m.get("four")
// res61: Option[Int] = None

Vector(("one", 1), ("two", 2), ("three", 3)).to(Map)
// res62: Map[String, Int] = Map("one" -> 1, "two" -> 2, "three" -> 3)

Map[String, Int]() + ("one" -> 1) + ("three" -> 3)
// res63: Map[String, Int] = Map("one" -> 1, "three" -> 3)

for ((k, v) <- m) print(k + " " + v + " ")
// one 1 two 2 three 3
