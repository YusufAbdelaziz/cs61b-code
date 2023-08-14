package DAGLPT;

import java.util.List;

import DAGSPT.DAGSP;
import shortestPaths.WeightedGraph;

public class DAGLPT {
  private DAGSP dagsp;

  public DAGLPT(WeightedGraph g) {
    g.flipEdgesSign();
    dagsp = new DAGSP(g);
  }

  public List<Integer> findLongestPath(int s) {
    return dagsp.findShortestPath(s);
  }
}
