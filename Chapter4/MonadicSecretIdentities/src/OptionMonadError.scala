import cats.MonadError

object OptionMonadError {

  def main(args: Array[String]): Unit = {

    type ErrorOr[A] = Either[String, A]

    implicit val optionMonadError: MonadError[Option, Unit] = new MonadError[Option, Unit] {
      override def pure[A](x: A): Option[A] = Option(x)
      override def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] = fa.flatMap(f)
      override def tailRecM[A, B](a: A)(f: A => Option[Either[A, B]]) = ???
      override def raiseError[A](e: Unit): Option[A] = None
      override def handleErrorWith[A](fa: Option[A])(f: Unit => Option[A]): Option[A] = fa.orElse(f(None))
    }

    val x = MonadError[Option, Unit]
    println(x.pure("Hello World"))
    println(x.raiseError())
    println(x.raiseError())
    println(x.handleErrorWith(x.raiseError())(_ => Some("HELLO")))

  }

}
