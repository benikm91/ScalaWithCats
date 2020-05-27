import model.Cat
import printable.{Printable, PrintableSyntax}

object PrintableLibrary {

  def main(args: Array[String]): Unit = {
    Printable.print(Cat("Cheshire", 5, "violet"))
    import PrintableSyntax._
    Cat("Unlucky", 13, "black").print
  }

}
