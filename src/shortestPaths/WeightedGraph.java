package shortestPaths;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeightedGraph {
  /**
   * Stores the vertex as a key, and the value is an array of vertices each is
   * associated with its weight.
   */
  private HashMap<Integer, ArrayList<Map.Entry<Integer, Integer>>> graph = new HashMap<>();
  private boolean negativeWeight;

  public WeightedGraph(int v, boolean negativeWeight) {
    for (int i = 0; i < v; i++) {
      graph.put(i, new ArrayList<>());
    }

    this.negativeWeight = negativeWeight;
  }

  public void addEdge(int v, int w, int weight) {
    if (v > this.graph.size() - 1)
      throw new RuntimeException("Can't add edge between " + v + " and " + "w since vertex v doesn't exist");
    if (w > this.graph.size() - 1)
      throw new RuntimeException("Can't add edge between " + v + " and " + "w since vertex w doesn't exist");

    if (!this.negativeWeight && weight < 0)
      throw new RuntimeException(
          "You can't have negative weights since you defined they are not allowed at the constructor");

    var vNeighbors = this.graph.get(v);
    if (!vNeighbors.contains(Map.entry(w, weight)))
      vNeighbors.add(Map.entry(w, weight));
  }

  public void addUndirectedEdge(int v, int w, int weight) {
    addEdge(v, w, weight);
    addEdge(w, v, weight);
  }

  /**
   * 
   * @return number of vertices in the graph.
   */
  public int V() {
    return graph.size();
  }

  /**
   * 
   * @return number of edges in the graph.
   */
  public int E() {
    var numOfEdges = 0;

    for (var arr : graph.values()) {
      numOfEdges += arr.size();
    }
    return numOfEdges;
  }

  /**
   * 
   * @param v vertex
   * @return adjacent vertices to v including the weight of edges.
   */
  public Iterable<Map.Entry<Integer, Integer>> adj(int v) {
    return this.graph.get(v);
  }

  public int findInDegree(int v) {
    int count = 0;

    var outDegrees = this.graph.values();

    for (ArrayList<Map.Entry<Integer, Integer>> arr : outDegrees) {
      for (Map.Entry<Integer, Integer> entry : arr) {
        if (entry.getKey() == v)
          count++;
      }
    }

    return count;
  }

  public List<Integer> findInDegreeZeroVertices() {
    ArrayList<Integer> list = new ArrayList<>();

    for (int i = 0; i < this.V(); i++) {
      if (findInDegree(i) == 0)
        list.add(i);
    }

    return list;
  }

  public void flipEdgesSign() {
    for (int i = 0; i < this.V(); i++) {
      ArrayList<Map.Entry<Integer, Integer>> neighbors = this.graph.get(i);
      ArrayList<Map.Entry<Integer, Integer>> updatedNeighbors = new ArrayList<>();

      for (Map.Entry<Integer, Integer> neighbor : neighbors) {
        Map.Entry<Integer, Integer> updatedNeighbor = new AbstractMap.SimpleEntry<>(
            neighbor.getKey(), -neighbor.getValue());
        updatedNeighbors.add(updatedNeighbor);
      }

      this.graph.put(i, updatedNeighbors);
    }
  }
}
