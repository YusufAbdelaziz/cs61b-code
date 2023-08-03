package graphTraversalAlgos;

public class Runner {
  public static void main(String[] args) {
    // This graph is defined in Lec 22, review slide.
    Graph g = new Graph(9);

    g.addUndirectedEdge(0, 1);

    g.addUndirectedEdge(1, 4);
    g.addUndirectedEdge(1, 2);

    g.addUndirectedEdge(2, 5);

    g.addUndirectedEdge(4, 5);
    g.addUndirectedEdge(4, 3);

    g.addUndirectedEdge(5, 6);
    g.addUndirectedEdge(5, 8);

    g.addUndirectedEdge(6, 7);

    Paths dfs = new DFSPaths(g, 0);
    Paths bfs = new BFSPaths(g, 0);
    System.out.println("DFS -> ");
    System.out.println(dfs.pathTo(8));
    System.out.println(dfs.hasPathTo(8));
    System.out.println("BFS -> ");
    System.out.println(bfs.pathTo(8));
    System.out.println(bfs.hasPathTo(8));

  }
}