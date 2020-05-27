package model

import cats.Monoid

case class Order(totalCost: Double, quantity: Double)

object Order {

  import cats.instances.double._

  implicit val orderMonoid: Monoid[Order] = new Monoid[Order] {
    override def empty = Order(0, 0)
    override def combine(x: Order, y: Order) = Order(
      Monoid[Double].combine(x.totalCost, y.totalCost),
      Monoid[Double].combine(x.quantity, y.quantity),
    )
  }

}
