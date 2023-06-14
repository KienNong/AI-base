
/*
 * A star
 * A KT
 \
 */
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

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
  public void addEdge(Node source, Node destination, int weight) {
    // Them canh dich vao DS ke cua dinh nguon
    source.setWeight(weight);
    destination.setWeight(weight);
    this.AdjacencyList.get(source.getValue()).add(destination);
    this.AdjacencyList.get(destination.getValue()).add(source);
  }

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

  public void printWeightedGraph() {
    for (int i = 0; i < AdjacencyList.size(); i++) {
      if (this.AdjacencyList.get(i).size() > 0) {
        System.out.print("Vertex AdjList: " + "[[" + i + "]]");
        for (Node neighbor : this.AdjacencyList.get(i)) {
          System.out.print(" -> {" + neighbor.getValue() + ", W: " + neighbor.getWeight() + "}");
        }
        System.out.println();
      }
    }
  }

  // ============================================================================================================================
  // ============================================================================================================================
  // ============================================================================================================================

  private PriorityQueue<Node> initOpenList() {
    PriorityQueue<Node> openList = new PriorityQueue<Node>();
    return openList;
  }

  private PriorityQueue<Node> initCloseList() {
    PriorityQueue<Node> closeList = new PriorityQueue<Node>();
    return closeList;
  }

  // pass
  private int weightPrev(Node p) {
    Node prev = p.getPrev();
    for (Node neighbor : AdjacencyList.get(p.getValue())) {
      if (prev.getValue() == neighbor.getValue()) {
        return neighbor.getWeight();
      }
    }
    return -1;
  }

  private int cost(Node p, Node q) {
    if (q.getValue() == p.getValue()) {
      return 0;
    }
    return cost(p.getPrev(), q) + weightPrev(p);
  }

  private int g(Node p) {
    int g = Integer.MAX_VALUE;
    g = p.getG();
    return g;
  }

  private int h(Node p) {
    int h = Integer.MAX_VALUE;
    return h;
  }

  private int f(Node p) {
    return g(p) + h(p);
  }

  private boolean isInOpenList(Node q, PriorityQueue<Node> openList) {
    boolean res = false;
    for (Node node : openList) {
      if (node.getValue() == q.getValue()) {
        return true;
      }
    }
    return res;
  }

  private boolean isInCloseList(Node q, PriorityQueue<Node> closeList) {
    boolean res = false;
    for (Node node : closeList) {
      if (node.getValue() == q.getValue()) {
        return true;
      }
    }
    return res;
  }

  // A*
  public void A_star(Node start, Node end) {
    // Buoc 1
    PriorityQueue<Node> openList = initOpenList();
    openList.add(start);
    PriorityQueue<Node> closeList = initCloseList();

    // Buoc 2
    while (!openList.isEmpty()) {
      Node p = openList.poll();
      if (p.getValue() == end.getValue()) {
        return;
      } else {
        closeList.add(p);
        for (Node q : this.AdjacencyList.get(p.getValue())) {
          // neu q da co trong open
          if (isInOpenList(q, openList)) {
            if (g(q) > g(p) + cost(p, q)) {
              q.setG(g(p) + cost(p, q)); // ~ g(q) = g(p) + cost(p, q)
              f(q);
              q.setPrev(p); // ~ prev(q) = p;
            }
            // neu q chua co trong open
          } else if (!isInOpenList(q, openList)) {
            q.setG(g(p) + cost(p, q));
            f(q);
            q.setPrev(p);
            openList.add(q);
            // neu co q trong close
          } else if (isInCloseList(q, closeList)) {
            if (g(q) > g(p) + cost(p, q)) {
              closeList.remove(q);
              openList.add(q);
            }
          }
        }
      }
    }
    // Buoc 3
  }
}

/*
 * Open: tập các trạng thái đã được sinh ra nhưng chưa được xét đến.
 * Close: tập các trạng thái đã được xét đến.
 * Cost(p, q): là khoảng cách giữa p, q.
 * g(p): khoảng cách từ trạng thái đầu đến trạng thái hiện tại p.
 * h(p): giá trị được lượng giá từ trạng thái hiện tại đến trạng thái đích.
 * f(p) = g(p) + h(p)
 * ------------------------------------
 * Bước 1:
 * Open: = {s}
 * Close: = {}
 * Bước 2: while (Open !={})
 * Chọn trạng thái (đỉnh) tốt nhất p trong Open (xóa p khỏi Open).
 * Nếu p là trạng thái kết thúc thì thoát.
 * Chuyển p qua Close và tạo ra các trạng thái kế tiếp q sau p.
 * Nếu q đã có trong Open
 * Nếu g(q) > g(p) + Cost(p, q)
 * g(q) = g(p) + Cost(p, q)
 * f(q) = g(q) + h(q)
 * prev(q) = p (đỉnh cha của q là p)
 * Nếu q chưa có trong Open
 * g(q) = g(p) + cost(p, q)
 * f(q) = g(q) + h(q)
 * prev(q) = p
 * Thêm q vào Open
 * Nếu q có trong Close
 * Nếu g(q) > g(p) + Cost(p, q)
 * Bỏ q khỏi Close
 * Thêm q vào Open
 * Bước 3: Không tìm được.
 */

// A_star
/*
 * 1. Initialize the open list
 * 2. Initialize the closed list
 * put the starting node on the open
 * list (you can leave its f at zero)
 * 
 * 3. while the open list is not empty
 * a) find the node with the least f on
 * the open list, call it "q"
 * 
 * b) pop q off the open list
 * 
 * c) generate q's 8 successors and set their
 * parents to q
 * 
 * d) for each successor
 * i) if successor is the goal, stop search
 * 
 * ii) else, compute both g and h for successor
 * successor.g = q.g + distance between
 * successor and q
 * successor.h = distance from goal to
 * successor (This can be done using many
 * ways, we will discuss three heuristics-
 * Manhattan, Diagonal and Euclidean
 * Heuristics)
 * 
 * successor.f = successor.g + successor.h
 * 
 * iii) if a node with the same position as
 * successor is in the OPEN list which has a
 * lower f than successor, skip this successor
 * 
 * iV) if a node with the same position as
 * successor is in the CLOSED list which has
 * a lower f than successor, skip this successor
 * otherwise, add the node to the open list
 * end (for loop)
 * 
 * e) push q on the closed list
 * end (while loop)
 */
