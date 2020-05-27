package model

import cats.Functor

object TreeFunctor {

  implicit val treeFunctor: Functor[Tree] = new Functor[Tree] {
    override def map[A, B](fa: Tree[A])(f: A => B): Tree[B] = {
      fa match {
        case Branch(left, right) => Branch(this.map(left)(f), this.map(right)(f))
        case Leaf(value) => Leaf(f(value))
      }
    }
  }

}
