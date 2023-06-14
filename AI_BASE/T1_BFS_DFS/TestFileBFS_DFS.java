public class TestFileBFS_DFS {
  public static void main(String[] args) {
    System.out.println("-----------------------------GRAPH-----------------------------\n");

    BFS_DFS g = new BFS_DFS(100);
    g.addEdge(1, 2);
    g.addEdge(2, 3);
    g.addEdge(3, 4);
    g.addEdge(3, 1);
    g.addEdge(4, 5);
    g.addEdge(2, 6);
    g.addEdge(6, 7);
    g.addEdge(6, 4);
    g.addEdge(7, 1);
    g.addEdge(7, 8);

    g.printGraph();
    g.BFS(5);
    g.DFS(5, 7);

    System.out.println("--------------------------------------------------------------");
  }
}
