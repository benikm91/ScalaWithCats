import Given._
import cats.{Semigroupal, Traverse}
import cats.implicits._

object TraversingWithVectors {

  def main(args: Array[String]): Unit = {
    import cats.instances.vector._
    println(Semigroupal[List].product(List(1, 2), List(3, 4)))
    println(listSequence(List(Vector(1, 2), Vector(3, 4), Vector(5, 6))))

    import cats.instances.option._
    def process(inputs: List[Int]): Option[List[Int]] =
      listTraverse(inputs)(n => if (n % 2 == 0) Some(n) else None)

    println(process(List(2, 4, 6)))
    println(process(List(1, 2, 3)))
  }

}
