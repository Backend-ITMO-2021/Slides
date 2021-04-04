package lecture6.secrets;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
  public static void main(String[] args) {
    try (InputStream input = ReadProperties.class.getClassLoader().getResourceAsStream("secrets.properties")) {
      Properties properties = new Properties();
      if (input == null) {
        System.out.println("Sorry, unable to find secrets.properties");
        return;
      }
      properties.load(input);

      System.out.println(properties.getProperty("sberbank.url"));
      System.out.println(properties.getProperty("sberbank.username"));
      System.out.println(properties.getProperty("sberbank.password"));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
