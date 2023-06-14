
public class Node {
  private int value;
  private int color;

  Node(int value) {
    this.value = value;
  }

  Node(int value, int color) {
    this.value = value;
    this.color = color;
  }

  Node() {
    this.value = 0;
    this.color = 0;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public void setColor(int color) {
    this.color = color;
  }

  public int getColor() {
    return this.color;
  }

  public int getValue() {
    return this.value;
  }
}
