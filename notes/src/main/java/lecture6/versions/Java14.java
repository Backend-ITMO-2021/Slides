package lecture6.versions;


public class Java14 {
  public static void main(String[] args) {
    switchExpression();
  }

  enum Person {
    Mozart, Picasso, Goethe, Dostoevsky, Prokofiev, Dali
  }

  private static void switchExpression() {
    print(Person.Mozart);
    print(Person.Dali);
    print(Person.Dostoevsky);
  }

  static void print(Person person) {
    String title = switch (person) {
      case Dali, Picasso -> "painter";
      case Mozart, Prokofiev -> "composer";
      case Goethe, Dostoevsky -> "writer";
    };
    System.out.printf("%s was a %s%n", person, title);
  }
}
