package lecture6.versions;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class Java9 {
  public static void main(String[] args) {
    collections();
    streams();
    optional();
  }

  private static void optional() {
    Optional<Integer> optional = Optional.ofNullable(null);
    optional.ifPresentOrElse(Integer::toBinaryString, () -> System.out.println("It's empty"));
  }

  private static void streams() {
    Stream<String> stream = Stream.iterate("", s -> s + "s")
        .takeWhile(s -> s.length() < 10);
  }

  private static void collections() {
    List<String> list = List.of("one", "two", "three");
    Set<String> set = Set.of("one", "two", "three");
    Map<String, String> map = Map.of("foo", "one", "bar", "two");
  }

  private interface MyInterface {

    private static void myPrivateMethod(){
      System.out.println("Yay, I am private!");
    }
  }
}
