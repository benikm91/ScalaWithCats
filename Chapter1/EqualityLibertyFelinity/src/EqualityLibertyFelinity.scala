import model.Cat

object EqualityLibertyFelinity {

  def main(args: Array[String]): Unit = {

    def catExample(): Unit = {
      import cats.syntax.eq._
      val c1 = Cat("Lucky", 3, "white")
      val c2 = Cat("Unlucky", 13, "black")
      println("c1 === c2", c1 === c2)
      println("c1 === c1", c1 === c1)
    }

    def optionExample(): Unit = {
      import cats.instances.option._
      import cats.syntax.eq._
      val optionCat = Option(Cat("Another", 5, "brown"))
      val none = Option.empty[Cat]
      println("optionCat === none", optionCat === none)
      println("optionCat === optionCat", optionCat === optionCat)
    }

    println("Cat Example")
    catExample()
    println("Option Example")
    optionExample()
  }

}
