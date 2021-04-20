package lecture7


object Implementations {

  lazy val intSumSemigroup: Semigroup[Int] = new Semigroup[Int] {
    def op(a: Int, b: Int): Int = a + b
  }

  def listSemigroup[A]: Semigroup[List[A]] = new Semigroup[List[A]] {
    def op(a: List[A], b: List[A]): List[A] = a ::: b
  }


  lazy val stringMonoid: Monoid[String] = new Monoid[String] {
    def op(a: String, b: String): String = a + b
    val zero: String = ""
  }

  def listMonoid[A]: Monoid[List[A]] = new Monoid[List[A]] {
    def op(a: List[A], b: List[A]): List[A] = a ++ b
    val zero: List[A] = Nil
  }

  lazy val optionFoldable: Foldable[Option] = new Foldable[Option] {
    def fold[A](fa: Option[A])(implicit F: Monoid[A]): A = foldMap(fa)(a => a)
    def foldMap[A, B](fa: Option[A])(f: A => B)(implicit F: Monoid[B]): B = foldr(fa, F.zero)(a => _ => f(a))
    def foldr[A, B](fa: Option[A], z: B)(f: A => B => B): B =
      fa match {
        case Some(a) => f(a)(z)
        case None => z
      }
  }

  lazy val optionFunctor: Functor[Option] = new Functor[Option] {
    def map[A, B](fa: Option[A])(f: A => B): Option[B] =
      fa match {
        case Some(value) => Some(f(value))
        case None => None
      }
  }

  def compositionFunctor[R] = {
    type Func[T] = Function[R, T]
    new Functor[Func] {
      def map[A, B](fa: Func[A])(f: A => B): Func[B] =
        fa andThen f
    }
  }

  lazy val optionApplicative: Applicative[Option] = new Applicative[Option] {
    def point[A](a: A): Option[A] = Some(a)
    def ap[A, B](fa: Option[A])(f: Option[A => B]): Option[B] =
      f match {
        case Some(value) => map(fa)(value)
        case None => None
      }
    def map[A, B](fa: Option[A])(f: A => B): Option[B] = optionFunctor.map(fa)(f)
  }

  lazy val listApplicative: Applicative[List] = new Applicative[List] {
    def point[A](a: A): List[A] = List(a)
    def ap[A, B](fa: List[A])(f: List[A => B]): List[B] =
      for {fs <- f; fas <- fa} yield fs(fas)
    def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
  }
  listApplicative.ap(List(1, 2, 3))(List[Int => Int](_ * 2, _ + 3))
}