import cats.data.State

object PostOrderCalculator {

  type CalcState[A] = State[List[Int], A]

  def evalOne(sym: String): CalcState[Int] = {
    def ApplyFFromStack(f: (Int, Int) => Int): CalcState[Int] = {
      State[List[Int], Int] {
        case x :: y :: rest =>
          val res = f(x, y)
          (res :: rest, res)
        case _ => throw new IllegalStateException()
      }
    }

    sym match {
      case "+" => ApplyFFromStack(_ + _)
      case "*" => ApplyFFromStack(_ * _)
      case x => State[List[Int], Int] { state => (x.toInt :: state, x.toInt) }
    }
  }

  def evalAll(input: List[String]): CalcState[Int] =
    input.map(evalOne).reduce((x, y) => x.flatMap(_ => y))

  def main(args: Array[String]): Unit = {
    val program = for {
      _ <- evalOne("3")
      _ <- evalOne("2")
      _ <- evalOne("3")
      _ <- evalOne("2")
      _ <- evalOne("2")
      _ <- evalOne("+")
      _ <- evalOne("+")
      _ <- evalOne("+")
      ans <- evalOne("*")
    } yield ans
    println(program.runA(Nil).value)

    val multistageProgram = evalAll(List("1", "2", "+", "3", "*"))
    println(multistageProgram.runA(Nil).value)

    val biggerProgram = for {
      _ <- evalAll(List("1", "2", "+"))
      _ <- evalAll(List("3", "4", "+"))
      ans <- evalOne("*")
    } yield ans

    println(biggerProgram.runA(Nil).value)

    while(true) {
      try {
        val input = scala.io.StdIn.readLine()
        val program = evalAll(input.split(" ").toList)
        println(program.runA(Nil).value)
      } catch {
        case e: Exception => println(e)
      }
    }

  }

}
