// type Option[T] = Some[T] | None
def hello(
  nameOpt: Option[String]
): Unit = {
  nameOpt match {
    case Some(name) => println(s"Hello $name")
    case None => println(s"Hello <unknown>")
  }
}
hello(None)
hello(Some("Ivan"))
Some("1")
None
Option("1")
Option(null)

Some("Ivan").getOrElse("<unknown>")
None.getOrElse("<unknown>")

def hello2(name: Option[String]) = {
  for (s <- name) println(s"Hello $s")
}
hello2(None)
hello2(Some("Vasya"))

def nameLength(name: Option[String]) = {
  name.map(_.length).getOrElse(-1)
}
nameLength(Some("Petya"))
nameLength(None)

