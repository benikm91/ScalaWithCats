trait Printable[A] extends PrintableTemplate[A] {

  def format(value: A): String
  def contramap[B](func: B => A): Printable[B] = {
    val original = this
    (value: B) => original.format(func(value))
  }
}

object Printable {
  def format[A](value: A)(implicit p: Printable[A]): String =
    p.format(value)
}
