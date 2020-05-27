import cats.{Applicative, Monad, MonadError}
import cats.implicits._

object Id {
  type Id[A] = A

  implicit val idMonad: Monad[Id] = new Monad[Id] {
    override def pure[A](x: A): Id[A] = x
    override def flatMap[A, B](fa: Id[A])(f: A => Id[B]): Id[B] = f(fa)
    override def tailRecM[A, B](a: A)(f: A => Id[Either[A, B]]) = ???
  }

  implicit val idApplicative: Applicative[Id] = new Applicative[Id] {
    override def pure[A](x: A) = x
    override def ap[A, B](ff: Id[A => B])(fa: Id[A]): B = ff(fa)
  }

}
