
public class SingleLinkedList {
  private Node headNode;

  // constructor
  SingleLinkedList() {
    this.headNode = null;
  }

  SingleLinkedList(Node headNode) {
    this.headNode = headNode;
  }

  // get - set
  public void setHeadNode(Node headNode) {
    this.headNode = headNode;
  }

  public Node getHeadNode() {
    return this.headNode;
  }

  public void addFisrt(Node node) {
    node.setNext(headNode);
    this.headNode = node;
  }

  public Node getFirst() {
    return this.headNode;
  }

  public void removeFirst() {
    headNode = headNode.getNext();
  }

  public void addLast(Node node) {
    if (headNode == null) {
      headNode = node;
    } else {
      Node currentNode = this.headNode;
      while (currentNode.getNext() != null) {
        currentNode = currentNode.getNext();
      }
      currentNode.setNext(node);
    }
  }

  public Node getLast() {
    if (headNode == null) {
      printlnEmpty();
      return new Node();
    }
    Node currentNode = this.headNode;
    while (currentNode.getNext() != null) {
      currentNode = currentNode.getNext();
    }
    return currentNode;
  }

  public void printlnEmpty() {
    System.out.println("SingleLinkedList is empty!!!");
  }

  public void removeLast() {
    if (this.headNode == null) {
      this.printlnEmpty();
    }
    if (this.headNode.getNext() == null) {
      this.headNode = null;
    } else {
      Node currentNode = headNode;
      while (currentNode.getNext().getNext() == null) {
        currentNode.setNext(null);
      }
    }
  }

  // view
  public String listToString() {
    if (headNode == null) {
      return null;
    }
    String str = "";
    Node currentNode = this.headNode;
    while (currentNode != null) {
      str += " | " + currentNode.getData();
      currentNode = currentNode.getNext();
    }
    return str;
  }

  // isEmpty
  public boolean isEmpty() {
    if (headNode == null) {
      return true;
    }
    return false;
  }
}