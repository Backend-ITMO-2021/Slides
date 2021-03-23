def iterateOverSomething[T](items: Seq[T]): Unit = {
  for (i <- items) println(i)
}
iterateOverSomething(Vector(1, 2, 3))
iterateOverSomething(List(("one", 1), ("two", 2), ("three", 3)))

def getIndexTwoAndFour[T](items: IndexedSeq[T]): (T, T) = (items(2), items(4))
getIndexTwoAndFour(Vector(1, 2, 3, 4, 5))
getIndexTwoAndFour(Array(2, 4, 6, 8, 10))

