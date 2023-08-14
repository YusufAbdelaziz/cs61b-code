package topologicalSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import graphTraversalAlgos.Graph;

public class TopologicalSort {
  private Graph g;
  private boolean[] marked;

  public TopologicalSort(Graph g) {
    this.g = g;
    marked = new boolean[g.V()];
  }

  public List<Integer> sort() {
    List<Integer> postOrder = new ArrayList<>();
    var list = g.findInDegreeZeroVertices();
    for (Integer v : list) {
      if (!marked[v])
        dfs(v, marked, postOrder);
    }
    Collections.reverse(postOrder);
    return postOrder;
  }

  private void dfs(Integer v, boolean[] marked, List<Integer> postOrder) {
    marked[v] = true;

    for (Integer neighbor : this.g.adj(v)) {
      if (!marked[neighbor])
        dfs(neighbor, marked, postOrder);
    }

    postOrder.add(v);
  }

}
