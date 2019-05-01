package github.yhs0092;

public class Coordinate {
  private double x;

  private double y;

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("Coordinate{");
    sb.append("x=").append(x);
    sb.append(", y=").append(y);
    sb.append('}');
    return sb.toString();
  }
}
