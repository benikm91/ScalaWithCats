import cats.data.EitherT
import cats.instances.future._
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Await, Future}
import scala.language.postfixOps

object TransformAndRollOut {

  type Response[A] = EitherT[Future, String, A]

  val powerLevels = Map("Jazz" -> 6, "Bumblebee" -> 8, "Hot Rod" -> 10)

  def getPowerLevel(autobot: String): Response[Int] = EitherT.fromOption[Future](
    powerLevels.get(autobot), s"$autobot not found"
  )

  def canSpecialMove(ally1: String, ally2: String): Response[Boolean] =
    for {
      first <- getPowerLevel(ally1)
      second <- getPowerLevel(ally2)
    } yield first + second >= 15

  def tacticalReport(ally1: String, ally2: String): String =
    Await.result(canSpecialMove(ally1, ally2).map {
      case false => s"$ally1 and $ally2 must recharge"
      case true => s"$ally1 and $ally2 can special attack"
    }.merge, 1 second)

  def main(args: Array[String]): Unit = {
    println(getPowerLevel("Not Found"))
    println(getPowerLevel("Jazz"))
    println(tacticalReport("Bumblebee", "Hot Rod"))
    println(tacticalReport("Bumblebee", "Jazz"))
    println(tacticalReport("Beni", "Jazz"))
  }

}
