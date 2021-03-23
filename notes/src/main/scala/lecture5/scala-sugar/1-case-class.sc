case class Point(x: Int, y: Int)
val p = Point(1, 2)
p.x
p.y

p.toString

val p2 = Point(1, 2)
p == p2

val p = Point(1, 2)
val p3 = p.copy(y = 10)
val p4 = p3.copy(x = 20)

case class Point(x: Int, y: Int) {
  def z: Int = x + y
}
val p = Point(1, 2)
p.z

