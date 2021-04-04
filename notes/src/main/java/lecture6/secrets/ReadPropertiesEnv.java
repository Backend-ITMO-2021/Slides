package lecture6.secrets;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesEnv {
  public static void main(String[] args) {
    try (InputStream input = new FileInputStream(System.getenv("SECRETS_LOCATION"))) {
      Properties properties = new Properties();
      properties.load(input);

      System.out.println(properties.getProperty("sberbank.url"));
      System.out.println(properties.getProperty("sberbank.username"));
      System.out.println(properties.getProperty("sberbank.password"));
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }
}
