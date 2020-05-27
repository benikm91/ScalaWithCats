import cats.Monoid
import cats.instances.int._
import cats.instances.option._
import model.Order

object AddingAllTheThings {

  def add[T: Monoid](items: List[T]): T = {
    items.foldLeft(Monoid[T].empty)(Monoid[T].combine)
  }

  def main(args: Array[String]): Unit = {
    println(add(List(1, 2, 3, 4)))
    println(add(List(Some(1), None, None, Option(4))))
    println(add(List(Order(1.0, 2.0), Order(2.0, 1.0))))
  }

}
