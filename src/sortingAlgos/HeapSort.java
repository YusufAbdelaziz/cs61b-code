package sortingAlgos;

import java.util.PriorityQueue;

public class HeapSort implements Sort {
  private int[] list;
  // Defines the boundary of the sorted region from the unsorted one.
  private int unsortedRegion;

  public HeapSort(int[] list) {
    this.list = list;
    unsortedRegion = list.length;
  }

  /**
   * In-place heapsort.
   * 
   * Sink the elements in reverse-order.
   * 
   * Time Complexity -> O(NlogN)
   * Space Complexity -> O(1)
   * 
   * Practically -> Inefficient due to access different parts of the array (cache
   * problem).
   * 
   */
  @Override
  public int[] sort() {
    heapify();
    for (int i = list.length - 1; i >= 0; i--) {
      list[i] = poll();
    }
    return list;
  }

  private int poll() {

    // Swap the root with the last child.
    swap(0, unsortedRegion - 1);
    var head = list[unsortedRegion - 1];
    // When the head is moved to last element in the array, the right part becomes
    // sorted and
    // unsorted region shrinks.
    unsortedRegion--;
    sink(0);
    return head;
  }

  private void swap(int i, int j) {
    if (i < 0 || j < 0 || i >= list.length || j >= list.length)
      throw new RuntimeException("Invalid indices");

    var temp = list[i];
    list[i] = list[j];
    list[j] = temp;

  }

  private void heapify() {
    for (int i = list.length; i >= 0; i--) {
      sink(i);
    }
  }

  private void sink(int index) {
    if (index >= unsortedRegion)
      return;
    int currentElement = list[index];
    int leftChildIndex = 2 * index + 1;
    int rightChildIndex = 2 * index + 2;
    Integer leftChildVal = null;
    Integer rightChildVal = null;
    if (leftChildIndex < unsortedRegion)
      leftChildVal = list[leftChildIndex];
    if (rightChildIndex < unsortedRegion)
      rightChildVal = list[rightChildIndex];

    /// If a left child exist, and the left child is bigger than the parent as well
    /// as bigger than the right child, then swap the left child with the parent.
    if (leftChildVal != null && currentElement < leftChildVal
        && (rightChildVal == null || leftChildVal >= rightChildVal)) {
      swap(index, leftChildIndex);
      sink(leftChildIndex);
    }
    /// Otherwise, check if the right child is bigger than the parent, then swap the
    /// right child with the parent
    else if (rightChildVal != null && currentElement < rightChildVal) {
      swap(index, rightChildIndex);
      sink(rightChildIndex);
    }
  }

  /**
   * Time Complexity -> O(NlogN)
   * Space Complexity -> O(N)
   * 
   */
  public int[] naiveSort() {
    // You can avoid adding the lambda because PQ's default is min-heap.
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
    int[] result = new int[list.length];
    for (Integer element : list) {
      pq.add(element);
    }
    for (int i = 0; i < result.length; i++) {
      result[i] = pq.poll();
    }

    return result;
  }

}
