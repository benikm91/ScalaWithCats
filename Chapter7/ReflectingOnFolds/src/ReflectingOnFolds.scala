object ReflectingOnFolds {

  def main(args: Array[String]): Unit = {
    // Careful: accumulated value will be passed in as second parameter on foldRight and as first parameter on foldLeft
    println(List(1, 2, 3, 4, 5).foldLeft(List[Int]())((x, y) => y :: x))
    println(List(1, 2, 3, 4, 5).foldRight(List[Int]())(_ :: _))

    // Careful: op is associative is not enough. z must be neutral element or op must be commutative as well.
    println(List(1, 2, 3, 4, 5).map(x => List(x)).foldLeft(List[Int](-1))(_ ++ _))
    println(List(1, 2, 3, 4, 5).map(x => List(x)).foldRight(List[Int](-1))(_ ++ _))
  }

}
