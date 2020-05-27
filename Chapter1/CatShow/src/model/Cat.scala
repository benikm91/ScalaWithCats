package model

import cats.Show
import cats.implicits._

case class Cat (name: String, age: Int, color: String)

object Cat {

  implicit val catShow: Show[Cat] = (value: Cat) =>
    s"${value.name.show} is a ${value.age.show} year-old ${value.color.show} cat."

}
