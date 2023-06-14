public class Test {

  public static void main(String[] args) {

    Graph g = new Graph(100);

    g.addEdge(new Node(1), new Node(2), 5);
    g.addEdge(new Node(2), new Node(3), 6);
    g.addEdge(new Node(3), new Node(4), 7);
    // g.addEdge(new Node(4), new Node(5));
    // g.addEdge(new Node(5), new Node(6));

    // g.addEdge(new Node(3), new Node(1));
    // g.addEdge(new Node(4), new Node(5));
    // g.addEdge(new Node(2), new Node(6));
    // g.addEdge(new Node(6), new Node(7));
    // g.addEdge(new Node(6), new Node(4));
    // g.addEdge(new Node(7), new Node(8));
    // g.addEdge(new Node(5), new Node(8));
    // g.addEdge(new Node(2), new Node(9));
    // g.addEdge(new Node(5), new Node(9));
    // g.addEdge(new Node(8), new Node(9));

    g.printWeightedGraph();
  }
}

/*
 * g.addEdge(new Node(1), new Node(2));
 * g.addEdge(new Node(1), new Node(3));
 * g.addEdge(new Node(1), new Node(4));
 * g.addEdge(new Node(1), new Node(5));
 * 
 * g.addEdge(new Node(2), new Node(1));
 * g.addEdge(new Node(2), new Node(3));
 * g.addEdge(new Node(2), new Node(4));
 * g.addEdge(new Node(2), new Node(5));
 * 
 * g.addEdge(new Node(3), new Node(2));
 * g.addEdge(new Node(3), new Node(1));
 * g.addEdge(new Node(3), new Node(4));
 * g.addEdge(new Node(3), new Node(5));
 * 
 * g.addEdge(new Node(4), new Node(2));
 * g.addEdge(new Node(4), new Node(3));
 * g.addEdge(new Node(4), new Node(1));
 * g.addEdge(new Node(4), new Node(5));
 * 
 * g.addEdge(new Node(5), new Node(2));
 * g.addEdge(new Node(5), new Node(3));
 * g.addEdge(new Node(5), new Node(1));
 * g.addEdge(new Node(5), new Node(4));
 */