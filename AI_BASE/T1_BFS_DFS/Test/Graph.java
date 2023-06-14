import java.util.LinkedList;
import java.util.Queue;

public class Graph {
  private int numOfVertices;

  private LinkedList<LinkedList<Integer>> AdjacencyList;

  // Constructor
  Graph(int numberOfVertices) {
    this.numOfVertices = numberOfVertices;
    this.AdjacencyList = new LinkedList<LinkedList<Integer>>();
    for (int i = 0; i < this.numOfVertices; i++) {
      this.AdjacencyList.add(new LinkedList<Integer>());
    }
  }

  public void addEdge(int source, int destination) {
    this.AdjacencyList.get(source).add(destination);
    this.AdjacencyList.get(destination).add(source);
  }

  public void printGraph() {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        System.out.print("Vertex [" + i + "] AdjList: ");
        for (int neighbor : this.AdjacencyList.get(i)) {
          System.out.print(" -> " + neighbor);
        }
        System.out.println();
      }
    }
  }

  public void BFS(int start) {
    boolean[] isVisited = new boolean[this.numOfVertices];
    for (int i = 0; i < this.numOfVertices; i++) {
      isVisited[i] = false;
    }
    isVisited[start] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.add(start);
    while (queue.isEmpty() == false) {
      int vertext = queue.peek();
      System.out.println("Thu tu duyet: " + vertext);
      queue.remove();
      for (int neighbor : this.AdjacencyList.get(vertext)) {
        if (isVisited[neighbor] == false) {
          queue.add(neighbor);
          isVisited[neighbor] = true;
        }
      }
    }
  }

  public void DFS() {

  }
}
