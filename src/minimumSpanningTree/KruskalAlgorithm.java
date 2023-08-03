package minimumSpanningTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import shortestPaths.WeightedGraph;

public class KruskalAlgorithm {
  private WeightedGraph g;
  private ArrayList<Map.Entry<Map.Entry<Integer, Integer>, Integer>> mst = new ArrayList<>();

  public KruskalAlgorithm(WeightedGraph g) {
    this.g = g;
  }

  public List<Map.Entry<Map.Entry<Integer, Integer>, Integer>> findMST() {
    // The element in a queue is a single map entry whose key is the two vertices
    // connected to each other
    // as a map entry and the value is the weight.
    PriorityQueue<Map.Entry<Map.Entry<Integer, Integer>, Integer>> pq = new PriorityQueue<>(
        (a, b) -> a.getValue() - b.getValue());

    for (int i = 0; i < g.V(); i++) {
      var neighbors = g.adj(i);
      for (Map.Entry<Integer, Integer> neighbor : neighbors) {
        var neighborVertex = neighbor.getKey();
        var neighborWeight = neighbor.getValue();
        // Check if, for example, 1 - 2 and 2 - 1 both don't exist
        if (!pq.contains(Map.entry(Map.entry(i, neighborVertex), neighborWeight))
            && !pq.contains(Map.entry(Map.entry(neighborVertex, i), neighborWeight))) {
          pq.add(Map.entry(Map.entry(i, neighborVertex), neighborWeight));
        }
      }
    }
    WeightedQuickUnionUF wq = new WeightedQuickUnionUF(g.V());

    while (!pq.isEmpty()) {
      var shortestEdge = pq.poll();
      var firstVertex = shortestEdge.getKey().getKey();
      var secondVertex = shortestEdge.getKey().getValue();
      // var weight = shortestEdge.getValue();
      // If they're not connected aka not in the same set, then union and add to MST.
      if (!(wq.find(firstVertex) == wq.find(secondVertex))) {
        wq.union(firstVertex, secondVertex);
        mst.add(shortestEdge);
      }
    }
    return mst;
  }

  public int mstTotalCost() {
    int i = 0;

    for (Map.Entry<Map.Entry<Integer, Integer>, Integer> entry : mst) {
      i += entry.getValue();
    }
    return i;
  }
}
