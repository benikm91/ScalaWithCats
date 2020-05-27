import cats.Eval

object SaferFoldingUsingEval {

  def foldRight[A, B](as: List[A], acc: B)(fn: (A, B) => B): B = as match {
    case head :: tail => fn(head, foldRight(tail, acc)(fn))
    case Nil => acc
  }

  def foldRightEval[A, B](as: List[A], acc: B)(fn: (A, B) => B): Eval[B] = as match {
    case head :: tail => Eval.defer {
      foldRightEval(tail, acc)(fn).map(res => fn(head, res))
    }
    case Nil => Eval.now(acc)
  }

  def main(args: Array[String]): Unit = {
    println(foldRightEval((1 to 1000000).toList, 0)(_ + _).value)
    try {
      println(foldRight((1 to 1000000).toList, 0)(_ + _))
      assert(assertion = false, "Unreachable");
    } catch {
      case _ : StackOverflowError =>
        println("StackOverflowError (As expected :D)")
    }
  }

}
