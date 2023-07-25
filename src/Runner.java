import shortestPaths.Dijkstra;
import shortestPaths.WeightedGraph;

public class Runner {
  public static void main(String[] args) {
    // This graph is defined in Lec 22, review slide.
    // Graph g = new Graph(9);

    // g.addUndirectedEdge(0, 1);

    // g.addUndirectedEdge(1, 4);
    // g.addUndirectedEdge(1, 2);

    // g.addUndirectedEdge(2, 5);

    // g.addUndirectedEdge(4, 5);
    // g.addUndirectedEdge(4, 3);

    // g.addUndirectedEdge(5, 6);
    // g.addUndirectedEdge(5, 8);

    // g.addUndirectedEdge(6, 7);

    // Paths dfs = new DFSPaths(g, 0);
    // Paths bfs = new BFSPaths(g, 0);
    // System.out.println("DFS -> ");
    // System.out.println(dfs.pathTo(8));
    // System.out.println(dfs.hasPathTo(8));
    // System.out.println("BFS -> ");
    // System.out.println(bfs.pathTo(8));
    // System.out.println(bfs.hasPathTo(8));

    // --------------------------------------------------

    /// Check 23 graph example.

    var weightedGraph = new WeightedGraph(7, false);

    weightedGraph.addEdge(0, 1, 2);
    weightedGraph.addEdge(0, 2, 1);

    weightedGraph.addEdge(1, 2, 5);
    weightedGraph.addEdge(1, 3, 11);
    weightedGraph.addEdge(1, 4, 3);

    weightedGraph.addEdge(2, 5, 15);

    weightedGraph.addEdge(3, 4, 2);

    weightedGraph.addEdge(4, 2, 1);
    weightedGraph.addEdge(4, 5, 4);
    weightedGraph.addEdge(4, 6, 5);

    weightedGraph.addEdge(6, 5, 1);
    weightedGraph.addEdge(6, 3, 1);

    var dijkstra = new Dijkstra(weightedGraph);

    var route = dijkstra.findShortest(0, 6);
    System.out.println(route);

  }
}