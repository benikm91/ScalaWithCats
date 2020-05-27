import cats.data.Writer
import cats.instances.vector._
import cats.syntax.applicative._
import cats.syntax.writer._

object ShowYourWorking {

  type Logged[A] = Writer[Vector[String], A]

  def slowly[A](body: => A) = try body finally Thread.sleep(100)

  def factorial(n: Int): Logged[Int] = {
    n match {
      case 0 => 1.pure[Logged]
      case n =>
        for {
          fn1 <- factorial(n - 1)
          ans = n * fn1
          _ <- Vector(s"fact $n $ans").tell
        } yield ans
    }
  }

  def main(args: Array[String]): Unit = {
    factorial(5).mapWritten(_.foreach(println))
  }

}
