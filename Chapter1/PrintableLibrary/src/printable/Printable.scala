package printable

trait Printable[T] {
  def format(value: T): String
}

object Printable {

  def format[T](value: T)(implicit printable: Printable[T]): String = printable.format(value)
  def print[T](value: T)(implicit printable: Printable[T]): Unit = println(format(value))

}
