import startingpoint.{Monoid, Semigroup}

object TheTruthAboutMonoids {

  implicit val orBoolSemigroup: Semigroup[Boolean] = (x: Boolean, y: Boolean) => x || y

  implicit val orBoolMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty = false
    override def combine(x: Boolean, y: Boolean): Boolean = orBoolSemigroup.combine(x, y)
  }

  implicit val andBoolSemigroup: Semigroup[Boolean] = (x: Boolean, y: Boolean) => x && y

  implicit val andBoolMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty = true
    override def combine(x: Boolean, y: Boolean): Boolean = andBoolSemigroup.combine(x, y)
  }

  implicit val xorBoolSemigroup: Semigroup[Boolean] = (x: Boolean, y: Boolean) => x ^ y

  implicit val eqBoolSemigroup: Semigroup[Boolean] = (x: Boolean, y: Boolean) => x == y

  implicit val eqBoolMonoid: Monoid[Boolean] = new Monoid[Boolean] {
    override def empty = true
    override def combine(x: Boolean, y: Boolean): Boolean = eqBoolSemigroup.combine(x, y)
  }

  def main(args: Array[String]): Unit = {
    assert(orBoolMonoid.combine(false, true))
    assert(!orBoolMonoid.combine(false, false))
    assert(orBoolMonoid.combine(true, true))
    for (x <- List(false, true))
      assert(orBoolMonoid.combine(orBoolMonoid.empty, x) == x)
    assert(!andBoolSemigroup.combine(false, true))
    assert(!andBoolSemigroup.combine(false, false))
    assert(andBoolSemigroup.combine(true, true))
    for (x <- List(false, true))
      assert(andBoolMonoid.combine(andBoolMonoid.empty, x) == x)
    assert(xorBoolSemigroup.combine(false, true))
    assert(!xorBoolSemigroup.combine(false, false))
    assert(!xorBoolSemigroup.combine(true, true))
    assert(!eqBoolSemigroup.combine(false, true))
    assert(eqBoolSemigroup.combine(false, false))
    assert(eqBoolSemigroup.combine(true, true))
    for (x <- List(false, true))
      assert(eqBoolMonoid.combine(eqBoolMonoid.empty, x) == x)
  }

}
