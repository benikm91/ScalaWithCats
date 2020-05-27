import model.{Branch, Leaf, Tree}
import model.TreeFunctor._
import cats.implicits._

object BranchingOutWithFunctors {

  def main(args: Array[String]): Unit = {
    val leaf: Tree[Int] = Leaf(5)
    println(leaf.map(_ * 2))
    val smallTree: Tree[Int] = Branch(Leaf(5), Leaf(10))
    println(smallTree.map(_ + 3))
  }

}
