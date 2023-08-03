package shortestPaths;

public class Runner {
  public static void main(String[] args) {

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