import startingpoint.{Monoid, Semigroup}

object AllSetsForMonoids {

  implicit def unionSetSemigroup[T]: Semigroup[Set[T]] = (x: Set[T], y: Set[T]) => x.union(y)

  implicit def unionSetMonoid[T]: Monoid[Set[T]] = new Monoid[Set[T]] {
    override def empty: Set[T] = Set.empty[T]
    override def combine(x: Set[T], y: Set[T]): Set[T] = unionSetSemigroup.combine(x, y)
  }

  implicit def intersectSetSemigroup[T]: Semigroup[Set[T]] = (x: Set[T], y: Set[T]) => x.intersect(y)

  implicit def intersectSetMonoid[T]: Monoid[Set[T]] = new Monoid[Set[T]] {
    override def empty: Set[T] = Set.empty[T]
    override def combine(x: Set[T], y: Set[T]): Set[T] = intersectSetSemigroup.combine(x, y)
  }

  def main(args: Array[String]): Unit = {
    val y = unionSetMonoid.combine(Set(1, 2), Set(3, 4))
    val x = unionSetMonoid.combine(Set(1, 2), Set(1, 1))
    println(y, x)
  }

}
