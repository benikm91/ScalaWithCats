import cats.Id

import scala.concurrent.Future

trait UptimeClient[F[_]] {

  def getUptime(hostname: String): F[Int]

}

trait RealUptimeClient extends UptimeClient[Future] {

  def getUptime(hostname: String): Future[Int]
}

private trait TraitTestUptimeClient extends UptimeClient[Id] {

  def getUptime(hostname: String): Id[Int]

}
