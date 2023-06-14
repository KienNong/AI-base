public class Queue extends SingleLinkedList {
  public void deQueue() {
    this.removeLast();
  }

  public void enQueue(Node node) {
    this.addFisrt(node);
  }

  @Override
  public void printlnEmpty() {
    System.out.println("Queue is empty!!!");
  }
}