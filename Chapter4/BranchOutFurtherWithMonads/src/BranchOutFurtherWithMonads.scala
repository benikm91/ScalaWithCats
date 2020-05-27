import Given._
import cats.Monad

object BranchOutFurtherWithMonads {

  val treeMonad: Monad[Tree] = new Monad[Tree] {
    override def flatMap[A, B](fa: Tree[A])(f: A => Tree[B]): Tree[B] = fa match {
      case Branch(left, right) => Branch(flatMap(left)(f), flatMap(right)(f))
      case Leaf(value) => f(value)
    }
    override def tailRecM[A, B](a: A)(f: A => Tree[Either[A, B]]): Tree[B] = {
      def handleEitherTree(a: Tree[Either[A, B]]): Tree[B] = a match {
        case Branch(left, right) => Branch(handleEitherTree(left), handleEitherTree(right))
        case Leaf(Left(value)) => tailRecM(value)(f)
        case Leaf(Right(value)) => Leaf(value)
      }
      f(a) match {
        case Leaf(Left(value)) => tailRecM(value)(f)
        case Leaf(Right(value)) => Leaf(value)
        case x => handleEitherTree(x)
      }
    }

    override def pure[A](x: A): Tree[A] = leaf(x)
  }

}
