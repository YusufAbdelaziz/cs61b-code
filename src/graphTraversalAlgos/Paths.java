package graphTraversalAlgos;

public interface Paths {

  boolean hasPathTo(int v);

  Iterable<Integer> pathTo(int v);
}
