package lecture4.inheritance;

import java.awt.*;

public interface Shape {
  void draw(Graphics g);

  Color getColor();

  void setColor(Color color);

  void shift(int dx, int dy);
}
