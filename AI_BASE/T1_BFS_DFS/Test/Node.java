public class Node {
  private int data;
  private Node next;
  private boolean isVisited;

  Node() {
    this.isVisited = false;
    this.data = 0;
    this.next = null;
  }

  Node(int data) {
    this.isVisited = false;
    this.data = data;
    this.next = null;
  }

  Node(int data, Node next) {
    this.data = data;
    this.next = next;
  }

  public void setIsVisited() {
    this.isVisited = true;
  }

  public boolean getIsVisited() {
    return this.isVisited;
  }

  public int getData() {
    return this.data;
  }

  public void setData(int data) {
    this.data = data;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node next) {
    this.next = next;
  }
}
