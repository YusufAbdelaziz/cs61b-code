package minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import shortestPaths.WeightedGraph;

/**
 * PrimAlgorithm
 */
public class PrimAlgorithm {
  private WeightedGraph g;
  private int[] distTo;
  private int[] edgeTo;
  List<Integer> mst = new ArrayList<>();

  public PrimAlgorithm(WeightedGraph g) {
    this.g = g;
    distTo = new int[g.V()];
    edgeTo = new int[g.V()];
  }

  public ArrayList<Map.Entry<Integer, Integer>> findMST() {
    boolean[] marked = new boolean[g.V()];

    // V is the randomly picked start vertex. You can use any other vertex.
    int v = 0;
    distTo[v] = 0;
    for (int i = 0; i < distTo.length; i++) {
      if (i != v)
        distTo[i] = Integer.MAX_VALUE;
    }

    for (int i = 0; i < marked.length; i++) {
      marked[i] = false;
    }

    // Key of the entry is the vertex, and the value is the cost.
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

    /// This will set 0 to the starting vertex, and infinity (or max value) to other
    /// vertices
    pq.add(Map.entry(v, 0));

    // Insert all vertices to the PQ.
    for (int i = 0; i < g.V(); i++) {
      if (i != v) {
        pq.add(Map.entry(i, Integer.MAX_VALUE));
      }
    }
    while (!pq.isEmpty()) {

      var currentNode = pq.poll().getKey();
      marked[currentNode] = true;
      var neighbors = g.adj(currentNode);
      // A neighbor is a pair of the vertex and the weight to reach it.
      for (var neighbor : neighbors) {
        // If the new distance (which is the edge + the cumulative cost) less than the
        // stored one, then replace it.
        var neighborWeight = neighbor.getValue();
        var neighborVertex = neighbor.getKey();
        if (!marked[neighborVertex] && neighborWeight < distTo[neighborVertex]) {
          // Remove the old vertex with old distance value.
          pq.remove(Map.entry(neighborVertex, distTo[neighborVertex]));
          distTo[neighborVertex] = neighborWeight;
          edgeTo[neighborVertex] = currentNode;
          pq.add(Map.entry(neighborVertex, distTo[neighborVertex]));
        }
      }
    }

    for (int i = 0; i < edgeTo.length; i++) {
      if (i != v) {
        mst.add(edgeTo[i]);
      }
    }
    var list = new ArrayList<Map.Entry<Integer, Integer>>();
    for (int i = 1; i <= mst.size(); i++) {
      list.add(Map.entry(mst.get(i - 1), i));
    }
    return list;
  }

  public int mstTotalCost() {
    int cost = 0;
    for (int i : distTo) {
      cost += i;
    }
    return cost;
  }
}