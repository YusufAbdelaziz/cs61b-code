package DAGLPT;

import shortestPaths.WeightedGraph;

public class Runner {
  public static void main(String[] args) {

    // Lec 28 - DAGLPT example.
    WeightedGraph g = new WeightedGraph(6, true);

    g.addEdge(0, 3, 2);
    g.addEdge(0, 1, 1);

    g.addEdge(1, 2, 6);

    g.addEdge(3, 1, 4);
    g.addEdge(3, 4, 3);

    g.addEdge(2, 5, 2);
    g.addEdge(2, 4, 1);

    g.addEdge(4, 5, 1);

    DAGLPT daglpt = new DAGLPT(g);
    System.out.println("edgeTo -> " + daglpt.findLongestPath(0));

  }
}
