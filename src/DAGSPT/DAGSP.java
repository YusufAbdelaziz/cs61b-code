package DAGSPT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import shortestPaths.WeightedGraph;

public class DAGSP {
  private WeightedGraph g;
  private boolean[] marked;
  private int[] edgeTo;
  private int[] distTo;

  public DAGSP(WeightedGraph g) {
    this.g = g;
    edgeTo = new int[g.V()];
    distTo = new int[g.V()];
    marked = new boolean[g.V()];

  }

  public List<Integer> findShortestPath(int s) {
    var topologicalSort = sortTopologically(g);
    for (int i = 0; i < distTo.length; i++) {
      if (i != s)
        distTo[i] = Integer.MAX_VALUE;
    }

    for (Integer vertex : topologicalSort) {
      var neighbors = g.adj(vertex);
      for (Map.Entry<Integer, Integer> neighbor : neighbors) {
        var neighborVertex = neighbor.getKey();
        var neighborWeight = neighbor.getValue();
        if (distTo[vertex] + neighborWeight < distTo[neighborVertex]) {
          distTo[neighborVertex] = distTo[vertex] + neighborWeight;
          edgeTo[neighborVertex] = vertex;
        }
      }
    }
    ArrayList<Integer> result = new ArrayList<>();
    for (Integer vertexFrom : edgeTo) {
      result.add(vertexFrom);
    }
    return result;
  }

  private List<Integer> sortTopologically(WeightedGraph g) {
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

    for (Map.Entry<Integer, Integer> neighbor : this.g.adj(v)) {
      if (!marked[neighbor.getKey()])
        dfs(neighbor.getKey(), marked, postOrder);
    }

    postOrder.add(v);
  }
}
