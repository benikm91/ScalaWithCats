import cats.implicits._
import Given._
import cats.data.Validated

object FormValidation {

  type RequestData = Map[String, String]

  def getValue(params: RequestData, key: String): Option[String] =
    params.get(key)

  def parseInt(value: String): Either[NumberFormatException, Int] =
    Either.catchOnly[NumberFormatException](value.toInt)

  def nonBlank(value: String): Boolean = value.length > 0

  def nonNegative(value: Int): Boolean = value >= 0

  def readName(params: RequestData): Either[List[String], String] = for {
    value <- getValue(params, "name").toRight(List("Name not found"))
      .ensure(List("Name must not be blank"))(nonBlank)
  } yield value

  def readAge(params: RequestData): Either[List[String], Int] = for {
    value <- getValue(params, "age").toRight(List("Age not found"))
    valueInt <- parseInt(value).leftMap(_ => List("Age must be a integer"))
      .ensure(List("Age must be a positive integer"))(nonNegative)
  } yield valueInt

  def main(args: Array[String]): Unit = {
    val legalInput = Map(
      "name" -> "Beni",
      "age" -> "28"
    )
    val illegalInput = Map(
      "name" -> ""
    )
    def validateInput(input: RequestData): Validated[List[String], User] = {
      val name = readName(input).toValidated
      val age = readAge(input).toValidated
      name.product(age).map((User.apply _).tupled)
    }
    def eitherInput(input: RequestData): Either[List[String], User] = {
      for {
        name <- readName(input)
        age <- readAge(input)
      } yield User(name, age)
    }
    println(validateInput(legalInput))
    println(validateInput(illegalInput))
    println(eitherInput(legalInput))
    println(eitherInput(illegalInput))
  }

}
