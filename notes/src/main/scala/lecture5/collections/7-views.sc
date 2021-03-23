val myArray = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)

val myNewArray = myArray.map(x => x + 1).filter(x => x % 2 == 0).slice(1, 3)
// myNewArray: Array[Int] = Array(4, 6)

val myNewArray = myArray.view.map(_ + 1).filter(_ % 2 == 0).slice(1, 3).to(Array)
// myNewArray: Array[Int] = Array(4, 6)