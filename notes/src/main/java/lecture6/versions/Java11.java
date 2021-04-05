package lecture6.versions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.BinaryOperator;

public class Java11 {
  public static void main(String[] args) {
    strings();
    try {
      files();
    } catch (IOException exception) {
      exception.printStackTrace();
    }
    lambdaVar();
  }

  private static void lambdaVar() {
    BinaryOperator<String> test = (var s1, var s2) -> s1 + s2;
    System.out.println("test\ntest2\ntest3".lines().reduce("", (var s1, var s2) -> s1 + s2));
    System.out.println("test\ntest2\ntest3".lines().reduce("", test));
  }

  private static void files() throws IOException {
    Path path = Files.writeString(Files.createTempFile("helloworld", ".txt"), "Hi, my name is!");
    String s = Files.readString(path);
    System.out.println(s);
  }

  private static void strings() {
    var blank = "Marco".isBlank();
    System.out.println(blank);
    var lines = "Mar\nco".lines();
    System.out.println(lines);
    var strip = "Marco  ".strip();
    System.out.println(strip);
  }
}
