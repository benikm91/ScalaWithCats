package model

import cats.Eq
import cats.implicits._

case class Cat (name: String, age: Int, color: String)

object Cat {

  implicit val catEq: Eq[Cat] = (x: Cat, y: Cat) =>
    x.name === y.name &&
    x.age === y.age &&
    x.color === y.color

}
