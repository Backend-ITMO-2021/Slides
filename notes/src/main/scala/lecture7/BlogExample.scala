package lecture7

object BlogExample {
  case class Post(title: String, body: String)

  case class Blog(posts: List[Post], counter: Int)

  val readPost: Int => Blog => (Post, Blog) =
    i => blog => (blog.posts(i), blog.copy(counter = blog.counter + 1))

  val newPost: Post => Blog => Blog =
    post => blog => blog.copy(posts = post :: blog.posts)

  val read12AndNew: Blog => (Post, Post, Blog) = blog => {
    val (post1, blog1) = readPost(1)(blog)
    val blog2 = newPost(Post("Bla Bla", "<text>"))(blog1)
    val (post2, blog3) = readPost(2)(blog2)
    (post1, post2, blog3)
  }

  case class BlogM[A](action: Blog => (A, Blog))

  val readPost1: Int => BlogM[Post] =
    i => BlogM(readPost(i))
  val newPost1: Post => BlogM[()] =
    post => BlogM(newPost(post) andThen (blog => ((), blog)))

  val blogMonad: Monad[BlogM] = new Monad[BlogM] {
    def point[A](a: A): BlogM[A] = BlogM(b => (a, b))
    def flatMap[A, B](fa: BlogM[A])(f: A => BlogM[B]): BlogM[B] = BlogM(
      b => {
        val (r, b1) = fa.action(b)
        val h = f(r)
        h.action(b1)
      }
    )
  }

  val read12AndNew1: BlogM[(Post, Post)] =
    blogMonad.flatMap(readPost1(1))(post1 =>
      blogMonad.flatMap(newPost1(Post("Bla Bla", "<text>")))(_ =>
        blogMonad.flatMap(readPost1(2))(post2 =>
          blogMonad.point(post1, post2)
        )
      )
    )

  val optionMonad: Monad[Option] = new Monad[Option] {
    def point[A](a: A): Option[A] = Some(a)
    def flatMap[A, B](fa: Option[A])(f: A => Option[B]): Option[B] =
      fa match {
        case Some(value) => f(value)
        case None => None
      }
  }

  val listMonad: Monad[List] = new Monad[List] {
    def point[A](a: A): List[A] = List(a)
    def flatMap[A, B](fa: List[A])(f: A => List[B]): List[B] =
      for {
        a <- fa
        b <- f(a)
      } yield b
  }
}
