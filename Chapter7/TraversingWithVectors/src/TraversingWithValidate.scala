import Given._

object TraversingWithValidate {

  def main(args: Array[String]): Unit = {

    import cats.data.Validated
    import cats.instances.list._
    type ErrorsOr[A] = Validated[List[String], A]

    def process(inputs: List[Int]): ErrorsOr[List[Int]] =
      listTraverse(inputs) { n =>
        if (n % 2 == 0)
          Validated.valid(n)
        else
          Validated.invalid(List(s"$n is not even"))
      }

    println(process(List(2, 4, 6)))
    println(process(List(1, 2, 3)))

  }

}
