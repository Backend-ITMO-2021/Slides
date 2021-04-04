package lecture6.secrets;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class WriteProperties {
  public static void main(String[] args) {
    try (OutputStream output = new FileOutputStream("./src/main/resources/secrets.properties")) {
      Properties properties = new Properties();

      properties.setProperty("sberbank.url", "sberbank.ru");
      properties.setProperty("sberbank.user", "IvanIvanov");
      properties.setProperty("sberbank.password", "Qwerty1234");

      properties.store(output, null);

      System.out.println(properties);
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
