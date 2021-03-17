package lecture4.inheritance;

import java.awt.*;

public class Circle extends AbstractShape {
  private int r;

  public Circle(final Color color, final int x, final int y, final int r) {
    super(color, x, y);
    this.r = r;
  }

  @Override
  protected void drawImpl(final Graphics g) {
    g.fillOval(x - r, y - r, r * 2, r * 2);
  }

  @Override
  public Circle copy() {
    return new Circle(color, x, y, r);
  }
}
