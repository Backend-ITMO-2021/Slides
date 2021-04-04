package lecture6.secrets;

import java.util.Map;

public class EnvVariables {
  public static void main(String[] args) {
    Map<String, String> environment = System.getenv();
    System.out.println(environment.get("sberbank.url"));
    System.out.println(environment.get("sberbank.username"));
    System.out.println(environment.get("sberbank.password"));
  }
}
