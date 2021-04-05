public class Java16 {

  public static void main(String[] args) {
    records();
    patternMatching();
    patternMatchingInIf();
  }

  record Point(int x, int y) {}
  record Rectangle(Point a, Point b) { int length() { return 10; }}
  private static void records() {
    var point = new Point(1, 2);
    System.out.println(point.x);
    System.out.println(point.y);
  }

  private static void patternMatching() {
    var obj = new String("hello");
    if (obj instanceof String s) {
      System.out.println(s.contains("hello"));
    }
  }

  private static void patternMatchingInIf() {
    var a = new Rectangle(new Point(1,2), new Point(2,3));
    if (a instanceof Rectangle s && s.length() > 5) {
      System.out.println("Long boy");
    } else {
      System.out.println("Short boy");
    }
  }
}
