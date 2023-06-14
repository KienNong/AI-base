public class Stack extends SingleLinkedList {

  public void push(Node node) {
    this.addLast(node);
  }

  public void pop() {
    this.removeLast();
  }

  public void isFull() {

  }

  public int top() {
    return this.getLast().getData();
  }

  @Override
  public void printlnEmpty() {
    System.out.println("Stack is empty!!!");
  }
}
