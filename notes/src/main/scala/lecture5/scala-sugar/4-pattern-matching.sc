def dayOfWeek(x: Int): String = x match {
  case 1 => "Mon";
  case 2 => "Tue"
  case 3 => "Wed";
  case 4 => "Thu"
  case 5 => "Fri";
  case 6 => "Sat"
  case 7 => "Sun";
  case _ => "Unknown"
}
dayOfWeek(5)
dayOfWeek(-1)

def indexOfDay(d: String): Int = d match {
  case "Mon" => 1;
  case "Tue" => 2
  case "Wed" => 3;
  case "Thu" => 4
  case "Fri" => 5;
  case "Sat" => 6
  case "Sun" => 7;
  case _ => -1
}
indexOfDay("Fri")
indexOfDay("???")

for (i <- Range.inclusive(1, 100)) {
  val s = (i % 3, i % 5) match {
    case (0, 0) => "FizzBuzz"
    case (0, _) => "Fizz"
    case (_, 0) => "Buzz"
    case _ => i
  }
  println(s)
}

for (i <- Range.inclusive(1, 100)) {
  val s = (i % 3 == 0, i % 5 == 0) match {
    case (true, true) => "FizzBuzz"
    case (true, false) => "Fizz"
    case (false, true) => "Buzz"
    case (false, false) => i
  }
  println(s)
}

case class Point(x: Int, y: Int)

def direction(p: Point): String = p match {
  case Point(0, 0) => "origin"
  case Point(_, 0) => "horizontal"
  case Point(0, _) => "vertical"
  case _ => "diagonal"
}
direction(Point(0, 0))
direction(Point(1, 1))
direction(Point(10, 0))

def splitDate(s: String): String = s match {
  case s"$day-$month-$year" =>
    s"day: $day, mon: $month, yr: $year"
  case _ => "not a date"
}
splitDate("9-8-1965")
splitDate("9-8")

case class Person(name: String, title: String)

def greet(p: Person): Unit = p match {
  case Person(s"$firstName $lastName", title) =>
    println(s"Hello $title $lastName")
  case Person(name, title) =>
    println(s"Hello $title $name")
}
greet(Person("Alison Anderson", "Mr"))
greet(Person("House-Home", "Dr"))

def greet2(husband: Person, wife: Person): Unit =
  (husband, wife) match {
    case (Person(s"$first1 $last1", _), Person(s"$first2 $last2", _))
      if last1 == last2 =>
      println(s"Hello Mr and Ms $last1")
    case (Person(name1, _), Person(name2, _)) =>
      println(s"Hello $name1 and $name2")
  }



greet2(Person("James Bond", "Mr"), Person("Jane Bond", "Ms"))
greet2(Person("James Bond", "Mr"), Person("Jane", "Ms"))

val a = List((1, "one"), (2, "two"), (3, "three"))
for {
  (i, s) <- a
} println(s + i)

case class Point(x: Int, y: Int)

val p = Point(123, 456)
val Point(x, y) = p

val s"$first $second" = "Hello World"
val flipped = s"$second $first"
val s"$first $second" = "Hello"