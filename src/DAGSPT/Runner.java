package DAGSPT;

import shortestPaths.WeightedGraph;

public class Runner {
  public static void main(String[] args) {
    WeightedGraph g = new WeightedGraph(6, true);

    g.addEdge(0, 3, 1);
    g.addEdge(0, 1, 1);

    g.addEdge(1, 2, 6);

    g.addEdge(3, 1, 25);
    g.addEdge(3, 4, 1);

    g.addEdge(2, 5, 1);
    g.addEdge(2, 4, -20);

    g.addEdge(4, 5, 1);

    DAGSP dagsp = new DAGSP(g);
    System.out.println("edgeTo -> " + dagsp.findShortestPath(0));

  }
}
