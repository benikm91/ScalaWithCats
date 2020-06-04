import cats.Monoid

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import cats.implicits._

import scala.concurrent.duration._
import scala.language.postfixOps

object ImplementingFoldMap {

  def foldMap[A, B: Monoid](seq: Vector[A])(f: A => B): B = {
    val monoidB = Monoid.apply[B]
    seq.map(f).foldLeft(monoidB.empty)(monoidB.combine)
  }

  def parallelFoldMap[A, B : Monoid] (values: Vector[A]) (func: A => B): Future[B] = {
    val monoidB = Monoid.apply[B]
    for {
      groupEndValues <- values
        .grouped(Runtime.getRuntime.availableProcessors).toVector
        .map(values => Future { foldMap(values)(func) })
        .sequence
    } yield monoidB.combineAll(groupEndValues)
  }

  def main(args: Array[String]): Unit = {
    println(foldMap(Vector(1, 2, 3))(identity))
    println(foldMap(Vector(1, 2, 3))(_.toString + "! "))
    println(foldMap("Hello world!".toVector)(_.toString.toUpperCase))
  }

}
