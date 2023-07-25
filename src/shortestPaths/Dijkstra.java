package shortestPaths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Dijkstra
 */
public class Dijkstra {
  private WeightedGraph g;

  public Dijkstra(WeightedGraph g) {
    this.g = g;
  }

  public List<Integer> findShortest(int v, int w) {
    int[] distTo = new int[g.V()];
    int[] edgeTo = new int[g.V()];

    distTo[v] = 0;
    for (int i = 0; i < distTo.length; i++) {
      if (i != v)
        distTo[i] = Integer.MAX_VALUE;
    }

    // Key of the entry is the vertex, and the value is the cost.
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

    /// This will set 0 to the starting vertex, and infinity (or max value) to other
    /// vertices
    pq.add(Map.entry(v, 0));

    for (int i = 0; i < g.V(); i++) {
      if (i != v) {
        pq.add(Map.entry(i, Integer.MAX_VALUE));
      }
    }
    // System.out.println("PQ -> " + pq.toString());
    while (!pq.isEmpty()) {
      var currentNode = pq.poll().getKey();
      var neighbors = g.adj(currentNode);
      // A neighbor is a pair of the vertex and the weight to reach it.
      for (var neighbor : neighbors) {
        // If the new distance (which is the edge + the cumulative cost) less than the
        // stored one, then replace it.
        var neighborWeight = neighbor.getValue();
        var neighborVertex = neighbor.getKey();
        if (neighborWeight + distTo[currentNode] < distTo[neighborVertex]) {
          pq.remove(Map.entry(neighborVertex, distTo[neighborVertex]));
          distTo[neighborVertex] = neighborWeight + distTo[currentNode];
          edgeTo[neighborVertex] = currentNode;
          pq.add(Map.entry(neighborVertex, distTo[neighborVertex]));
        }
      }
    }
    List<Integer> path = new ArrayList<>();

    // Moving backwards starting from node v.
    for (int x = w; x != v; x = edgeTo[x]) {
      path.add(x);
    }

    path.add(v);

    Collections.reverse(path);
    return path;
  }

}