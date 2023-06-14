
public class Node {
  private int value;
  private int color;
  private int weight;
  private int g = Integer.MAX_VALUE;
  private Node prev;

  Node(int value) {
    this.value = value;
  }

  Node(int value, int weight) {
    this.value = value;
    this.weight = weight;
  }

  Node(int value, int color, int weight) {
    this.value = value;
    this.color = color;
    this.weight = weight;
  }

  Node() {
    this.weight = 0;
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

  public int getWeight() {
    return this.weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public int getG() {
    return this.g;
  }

  public void setG(int g) {
    this.g = g;
  }

  public void setPrev(Node prev) {
    this.prev = prev;
  }

  public Node getPrev() {
    return this.prev;
  }
}
