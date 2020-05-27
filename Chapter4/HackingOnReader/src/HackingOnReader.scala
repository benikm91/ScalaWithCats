import cats.Functor
import cats.data.Reader
import cats.implicits._

object HackingOnReader {

  type DbReader[A] = Reader[Db, A]

  def findUsername(userId: Int): DbReader[Option[String]] =
    Reader(db => db.usernames.get(userId))

  def checkPassword(username: String, password: String): DbReader[Boolean] = Reader(db =>
    db.passwords.get(username).contains(password)
  )

  def checkLogin(userId: Int, password: String): DbReader[Boolean] =
    for {
      oUsername <- findUsername(userId)
      correct <- oUsername.traverse(username => checkPassword(username, password))
    } yield correct.getOrElse(false)

  def main(args: Array[String]): Unit = {
    val users = Map(1 -> "dade", 2 -> "kate", 3 -> "margo")
    val passwords = Map("dade" -> "zerocool", "kate" -> "acidburn", "margo" -> "secret")
    val db = Db(users, passwords)
    println(checkLogin(1, "zerocool").run(db))
    // res7: cats.package.Id[Boolean] = true
    println(checkLogin(4, "davinci").run(db))
    // res8: cats.package.Id[Boolean] = false
  }

}
