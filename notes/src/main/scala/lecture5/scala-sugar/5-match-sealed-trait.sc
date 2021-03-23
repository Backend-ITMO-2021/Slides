sealed trait Expr

case class BinOp(
  left: Expr,
  op: String,
  right: Expr
) extends Expr

case class Literal(value: Int) extends Expr

case class Variable(name: String) extends Expr

def stringify(expr: Expr): String = expr match {
  case BinOp(left, op, right) =>
    s"(${stringify(left)} $op ${stringify(right)})"
  case Literal(value) => value.toString
  case Variable(name) => name
}
val largeExpr = BinOp(
  BinOp(Variable("x"), "+", Literal(1)),
  "*",
  BinOp(Variable("y"), "-", Literal(1))
)
stringify(largeExpr)

def evaluate(expr: Expr, values: Map[String, Int]): Int =
  expr match {
    case BinOp(left, "+", right) =>
      evaluate(left, values) + evaluate(right, values)
    case BinOp(left, "-", right) =>
      evaluate(left, values) - evaluate(right, values)
    case BinOp(left, "*", right) =>
      evaluate(left, values) * evaluate(right, values)
    case Literal(value) => value
    case Variable(name) => values(name)
  }
evaluate(largeExpr, Map("x" -> 10, "y" -> 20))