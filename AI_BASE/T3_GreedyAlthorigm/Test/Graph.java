
/*
 * GST2
 * To mau so 3
 \
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Graph {
  private int numOfVertices;
  private LinkedList<LinkedList<Node>> AdjacencyList;

  // Constructor
  Graph(int numberOfVertices) {
    this.numOfVertices = numberOfVertices;
    this.AdjacencyList = new LinkedList<LinkedList<Node>>();
    for (int i = 0; i < this.numOfVertices; i++) {
      this.AdjacencyList.add(new LinkedList<Node>());
    }
  }

  // addEdge
  public void addEdge(Node source, Node destination) {
    // Them canh dich vao DS ke cua dinh nguon
    this.AdjacencyList.get(source.getValue()).add(destination);
    this.AdjacencyList.get(destination.getValue()).add(source);
  }

  // printGraph
  public void printGraph() {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        System.out.print("Vertex AdjList: " + "[[" + i + "]]");
        for (Node neighbor : this.AdjacencyList.get(i)) {
          System.out.print(" -> " + neighbor.getValue());
        }
        System.out.println();
      }
    }
  }

  // ============================================================================================================================
  // ============================================================================================================================
  // ============================================================================================================================

  // Sort unColoringNodes descending
  private void sortDescending(ArrayList<Node> list, LinkedList<LinkedList<Node>> AdjacencyList) {
    Collections.sort(list, new Comparator<Node>() {

      @Override
      public int compare(Node node_1, Node node_2) {
        return AdjacencyList.get(node_1.getValue()).size() > AdjacencyList.get(node_2.getValue()).size() ? -1 : 1;
      }
    });
  }

  private void printArrListVal(ArrayList<Node> nodes) {
    System.out.print("\nArrayList value: " + "\n[");
    for (Node node : nodes) {
      System.out.print(node.getValue() + ", ");
    }
    System.out.println("]\n");
  }

  private void printLinkedListVal(LinkedList<Node> nodes) {
    System.out.print("\nLinkedList value: " + "\n[");
    for (Node node : nodes) {
      System.out.print(node.getValue() + ", ");
    }
    System.out.println("]\n");
  }

  private void initUnColoringNodes(ArrayList<Node> coloringNodes) {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        coloringNodes.add(new Node(i));
      }
    }
  }

  private void printColorNodes(ArrayList<Node> nodes) {
    for (Node node : nodes) {
      System.out.println("Node [" + node.getValue() + "] - color: " + node.getColor());
    }
  }

  private boolean isConnect(Node node, ArrayList<Node> list) {
    boolean res = false;
    for (Node n : list) {
      for (Node node2 : this.AdjacencyList.get(n.getValue())) {
        if (node2.getValue() == node.getValue()) {
          return true;
        }
      }
    }
    return res;
  }

  public void colorTwo() {
    // Khởi tạo và sắp xếp danh sách các Node cần tô theo thứ tự bậc giảm dần
    ArrayList<Node> coloringNodes = new ArrayList<>();
    initUnColoringNodes(coloringNodes);
    sortDescending(coloringNodes, AdjacencyList);

    int color = 1;
    ArrayList<Node> finalResult = new ArrayList<>();

    while (coloringNodes.size() != 0) {
      Node top = coloringNodes.get(0);
      // Tô màu đỉnh có bậc cao nhất
      top.setColor(color);

      ArrayList<Node> curColoredNodes = new ArrayList<>();
      curColoredNodes.add(top);

      finalResult.add(top);
      coloringNodes.remove(0);

      ArrayList<Node> coloringNodesCpy = (ArrayList) coloringNodes.clone();

      for (Node node : coloringNodes) {
        if (!isConnect(node, curColoredNodes)) {
          node.setColor(color);
          curColoredNodes.add(node);
          finalResult.add(node);
          coloringNodesCpy.remove(node);
        }
      }
      coloringNodes = coloringNodesCpy;
      color++;
    }

    printColorNodes(finalResult);
  }
}
