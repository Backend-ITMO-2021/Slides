package lecture6.versions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Java8 {
  public static void main(String[] args) {
    lambdas();
    anonymousClasses();
    streams();
  }

  private static void lambdas() {
    Function<Integer, Integer> test = x -> x + 2;
    System.out.println(test.apply(3));
  }

  private static void anonymousClasses() {
    Runnable runnable = new Runnable(){
      @Override
      public void run(){
        System.out.println("Hello world !");
      }
    };
    Runnable runnableShorter = () -> System.out.println("Hello world two!");
    runnable.run();
    runnableShorter.run();
  }

  private static void streams() {
    List<String> list = Arrays.asList("franz", "ferdinand", "fiel", "vom", "pferd");
    list.stream()
        .filter(name -> name.startsWith("f"))
        .map(String::toUpperCase)
        .sorted()
        .forEach(System.out::println);
  }
}
