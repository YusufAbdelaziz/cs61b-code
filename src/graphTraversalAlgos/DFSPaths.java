package graphTraversalAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSPaths implements Paths {
  /**
   * Tracks the vertices that are connected to s.
   */
  private boolean[] marked;
  /**
   * Stores the path from s to v;
   */
  private int[] edgeTo;
  private int s;
  private Graph g;

  public DFSPaths(Graph g, int s) {
    if (s > g.V() - 1 || s < 0)
      throw new RuntimeException("Make sure that the starting node is in the graph");

    this.marked = new boolean[g.V()];
    this.edgeTo = new int[g.V()];
    this.s = s;
    this.g = g;
    dfs(g, s);
  }

  private void dfs(Graph g, int v) {
    marked[v] = true;
    for (int w : g.adj(v)) {
      if (!marked[w]) {
        edgeTo[w] = v;
        dfs(g, w);
      }
    }
  }

  @Override
  public boolean hasPathTo(int v) {
    if (v > g.V() - 1 || v < 0)
      throw new RuntimeException("Please provide a valid ending node.");

    return marked[v];
  }

  @Override
  public Iterable<Integer> pathTo(int v) {
    if (!hasPathTo(v))
      return null;

    List<Integer> path = new ArrayList<>();

    // Moving backwards starting from node v.
    for (int x = v; x != s; x = edgeTo[x]) {
      path.add(x);
    }

    path.add(s);
    Collections.reverse(path);
    return path;
  }

}
