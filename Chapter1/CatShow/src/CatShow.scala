import cats.Show
import model.Cat

object CatShow {

  def main(args: Array[String]): Unit = {
    val showCat = implicitly[Show[Cat]]
    showCat.show(Cat("Cheshire", 5, "violet"))
    import cats.syntax.show._
    Cat("Unlucky", 13, "black").show
  }

}
