package graphTraversalAlgos;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * adjacency list based Graph
 */
public class Graph {

  private HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();

  public Graph(int v) {
    for (int i = 0; i < v; i++) {
      graph.put(i, new ArrayList<>());
    }
  }

  /**
   * 
   * Adds a directed edge v->w
   */
  public void addEdge(int v, int w) {
    if (v > this.graph.size() - 1)
      throw new RuntimeException("Can't add edge between " + v + " and " + "w since vertex v doesn't exist");
    if (w > this.graph.size() - 1)
      throw new RuntimeException("Can't add edge between " + v + " and " + "w since vertex w doesn't exist");

    var vArray = this.graph.get(v);
    if (!vArray.contains(w))
      vArray.add(w);
  }

  /**
   * Adds an undirected edge v <-> w.
   */
  public void addUndirectedEdge(int v, int w) {
    addEdge(v, w);
    addEdge(w, v);
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
   * @return adjacent vertices to v
   */
  Iterable<Integer> adj(int v) {
    return this.graph.get(v);
  }
}