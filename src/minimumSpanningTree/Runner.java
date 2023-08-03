package minimumSpanningTree;

import shortestPaths.WeightedGraph;

public class Runner {
  public static void main(String[] args) {

    /// Check Lecture 24 - Prim's graph.

    var weightedGraph = new WeightedGraph(7, false);

    weightedGraph.addUndirectedEdge(0, 1, 2);
    weightedGraph.addUndirectedEdge(0, 2, 1);

    weightedGraph.addUndirectedEdge(1, 2, 5);
    weightedGraph.addUndirectedEdge(1, 3, 11);
    weightedGraph.addUndirectedEdge(1, 4, 3);

    weightedGraph.addUndirectedEdge(2, 5, 15);
    weightedGraph.addUndirectedEdge(2, 4, 1);

    // weightedGraph.addUndirectedEdge(3, 4, 2);
    weightedGraph.addUndirectedEdge(3, 4, 3);

    weightedGraph.addUndirectedEdge(4, 5, 4);
    weightedGraph.addUndirectedEdge(4, 6, 3);

    weightedGraph.addUndirectedEdge(6, 5, 1);
    weightedGraph.addUndirectedEdge(6, 3, 1);

    // var prim = new PrimAlgorithm(weightedGraph);
    // System.out.println("Prim's Algorithm -> " + prim.findMST());

    // ---------------------------------------------------------

    // Note that Kruskal's example has 4 - 3 edge's weight as 3 instead of
    var kruskal = new KruskalAlgorithm(weightedGraph);
    System.out.println("Kruskal's Algorithm -> " + kruskal.findMST() + " and total cost is " + kruskal.mstTotalCost());

  }
}
