package lecture7

trait Semigroup[M] {
  def op(a: M, b: M): M

  trait SemigroupLaws {
    def associative(f1: M, f2: M, f3: M): Boolean =
      op(f1, op(f2, f3)) == op(op(f1, f2), f3)
  }
}

trait Monoid[M] extends Semigroup[M] {
  def zero: M
  def op(a: M, b: M): M

  trait MonoidLaws {
    def leftIdentity(a: M): Boolean = a == op(zero, a)
    def rightIdentity(a: M): Boolean = a == op(a, zero)
  }
}

trait Foldable[F[_]] {
  def fold[A](fa: F[A])(implicit F: Monoid[A]): A
  def foldMap[A, B](fa: F[A])(f: A => B)(implicit F: Monoid[B]): B
  def foldr[A, B](fa: F[A], z: B)(f: A => B => B): B
}

trait Functor[F[_]] {
  def map[A, B](fa: F[A])(f: A => B): F[B]

  trait FunctorLaws {
    def identity[A](fa: F[A]): Boolean = map(fa)(x => x) == fa
    def composite[A, B, C](fa: F[A], f1: A => B, f2: B => C): Boolean =
      map(map(fa)(f1))(f2) == map(fa)(f1 andThen f2)
  }
}

trait Applicative[F[_]] extends Functor[F] { self =>
  def point[A](a: A): F[A]
  def ap[A, B](fa: F[A])(f: F[A => B]): F[B]

  trait ApplicativeLaws {
    def identity[A](fa: F[A]): Boolean =
      fa == ap(fa)(point((a: A) => a))

    def composition[A, B, C](fbc: F[B => C], fab: F[A => B], fa: F[A]): Boolean =
      ap(ap(fa)(fab))(fbc) == ap(fa)(ap(fab)(map(fbc)((bc: B => C) => (ab: A => B) => bc compose ab)))

    def homomorphism[A, B](ab: A => B, a: A): Boolean =
      ap(point(a))(point(ab)) == point(ab(a))

    def interchange[A, B](f: F[A => B], a: A): Boolean =
      ap(point(a))(f) == ap(f)(point((f: A => B) => f(a)))
  }
}