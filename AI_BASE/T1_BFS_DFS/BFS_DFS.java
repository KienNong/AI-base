import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_DFS {
  private int numOfVertices;
  private LinkedList<LinkedList<Integer>> AdjacencyList;

  // Constructor
  BFS_DFS(int numberOfVertices) {
    this.numOfVertices = numberOfVertices;
    this.AdjacencyList = new LinkedList<LinkedList<Integer>>();
    for (int i = 0; i < this.numOfVertices; i++) {
      this.AdjacencyList.add(new LinkedList<Integer>());
    }
  }

  // addEdge
  public void addEdge(int source, int destination) {
    // Them canh dich vao DS ke cua dinh nguon
    this.AdjacencyList.get(source).add(destination);
    this.AdjacencyList.get(destination).add(source);
  }

  // printGraph
  public void printGraph() {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        System.out.print("Vertex AdjList: " + "[[" + i + "]]");
        for (int neighbor : this.AdjacencyList.get(i)) {
          System.out.print(" -> " + neighbor);
        }
        System.out.println();
      }
    }
  }

  // BFS
  public void BFS(int start) {
    boolean[] isVisited = new boolean[this.numOfVertices];
    for (int i = 0; i < this.numOfVertices; i++) {
      isVisited[i] = false;
    }

    Queue<Integer> queue = new LinkedList<>();
    // Add starting vertex to Q (1)
    queue.add(start);
    // Starting Vertex has been visited (2)
    isVisited[start] = true;
    Queue<Integer> rsq = new LinkedList<>();

    while (queue.isEmpty() == false) {
      int vertext = queue.peek();
      rsq.add(vertext);
      queue.remove();
      for (int neighbor : this.AdjacencyList.get(vertext)) {
        if (!isVisited[neighbor]) {
          queue.add(neighbor); // (1)
          isVisited[neighbor] = true; // (2)
        }
      }
    }
    System.out.println("\nThu tu duyet (BFS): " + rsq.toString());
  }

  // DFS same as BFS but use Stack instead of Queue
  public void DFS(int st, int end) {
    boolean[] visit = new boolean[this.AdjacencyList.size()];
    for (int i = 0; i < visit.length; i++) {
      visit[i] = false;
    }
    Stack<Integer> s = new Stack<Integer>();
    s.add(st);
    visit[st] = true;
    Stack<Integer> rss = new Stack<Integer>();

    int[] preVert = new int[numOfVertices * numOfVertices - 1];

    while (!s.isEmpty()) {
      int vertext = s.peek();
      s.pop();
      rss.push(vertext);
      for (int neighbor : this.AdjacencyList.get(vertext)) {
        if (!visit[neighbor]) {
          preVert[neighbor] = vertext;
          s.push(neighbor);
          visit[neighbor] = true;
        }
      }
    }
    System.out.println("\nThu tu duyet (DFS): " + rss.toString());

    int pre = end;
    int startPoint = st;
    LinkedList<Integer> way = new LinkedList<Integer>();
    while (preVert[pre] != 0) {
      way.addFirst(preVert[pre]);
      pre = preVert[pre];
    }
    System.out.println("\nDuong di tu " + startPoint + " den " + end + " la: " + way.toString());

  }
}
