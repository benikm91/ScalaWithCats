object ShowingOffWithContramap {


  implicit val stringPrintable: Printable[String] = (value: String) =>
    " \" " + value + " \" "
  implicit val booleanPrintable: Printable[Boolean] = (value: Boolean) =>
    if (value) "yes" else "no"
  implicit def boxPrintable[A: Printable]: Printable[Box[A]] = {
    val aPrintable = implicitly[Printable[A]]
    aPrintable.contramap[Box[A]](_.value)
  }

  def main(args: Array[String]): Unit = {
    println(stringPrintable.format("hello"))
    println(booleanPrintable.format(true))

    println(Printable.format(Box("hello world")))
    // boxPrintable.format(Box("helloWorld"))
    //// does not work because boxPrintable already needs implicit  Printable for type A, but
    //// compiler has no way determining type for parameter A, because Box[A] will be created later (when calling format).
  }

}

