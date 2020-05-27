package model

import printable.Printable

case class Cat (name: String, age: Int, color: String)

object Cat {

  import printable.PrintableInstances.{stringPrintable, intPrintable}

  implicit val printableCat: Printable[Cat] = new Printable[Cat] {
    override def format(value: Cat): String =
      s"${Printable.format(value.name)} is a ${Printable.format(value.age)} year-old ${Printable.format(value.color)} cat."
  }

}
