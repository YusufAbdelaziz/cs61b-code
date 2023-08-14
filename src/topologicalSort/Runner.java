package topologicalSort;

import graphTraversalAlgos.Graph;

public class Runner {

  public static void main(String[] args) {

    // Lec 28 - Topological Sorting example graph.
    // Graph g = new Graph(8);
    // g.addEdge(0, 3);
    // g.addEdge(0, 1);

    // g.addEdge(2, 3);
    // g.addEdge(2, 5);

    // g.addEdge(3, 5);

    // g.addEdge(4, 7);

    // g.addEdge(5, 4);
    // g.addEdge(5, 6);

    // Notebook example.

    Graph g = new Graph(6);

    g.addEdge(0, 3);
    g.addEdge(0, 2);

    g.addEdge(1, 2);
    g.addEdge(1, 4);

    g.addEdge(3, 5);

    g.addEdge(5, 4);

    var topologicalSort = new TopologicalSort(g);
    System.out.println(topologicalSort.sort());
  }
}
