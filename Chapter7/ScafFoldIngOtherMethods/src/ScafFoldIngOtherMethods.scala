import cats.{Foldable, Monoid}

object ScafFoldIngOtherMethods {

  def listMap[A, B](list: List[A])(f: A => B): List[B] =
    list.foldRight(List[B]())((x, y) => f(x) +: y)

  def listFlatMap[A, B](list: List[A])(f: A => List[B])(implicit listMonoid: Monoid[List[B]]): List[B] =
    list.foldRight(List[B]())((x, y) => listMonoid.combine(f(x), y))

  def listFilter[A](list: List[A])(f: A => Boolean): List[A] =
    list.foldRight(List[A]())((x, y) => if (f(x)) x :: y else y)

  def listSum[A: Monoid](list: List[A]): A =
    list.foldRight(Monoid[A].empty)(Monoid[A].combine)

  def main(args: Array[String]): Unit = {
    assert(listMap(List(1, 2, 3))(_ + 1) == List(2, 3, 4))
    import cats.instances.list._
    assert(listFlatMap(List(1, 2, 3))(x => (0 until x).map(_ => x).toList) == List(1, 2, 2, 3, 3, 3))
    assert(listFilter(List(1, 2, 3))(_ == 1) == List(1))
    import cats.instances.int._
    assert(listSum(List(1, 2, 3)) == 6)
    import cats.implicits._
  }

}
