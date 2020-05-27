trait PrintableTemplate[A] {

  def format(value: A): String
  def contramap[B](func: B => A): Printable[B]

}
