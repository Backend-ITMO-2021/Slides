class Foo(val value: Int)
def bar(implicit foo: Foo): Int =
  foo.value + 10
implicit val foo: Foo = new Foo(1)
bar
bar(foo)

