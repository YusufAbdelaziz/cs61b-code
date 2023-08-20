package sortingAlgos;

public class InsertionSort implements Sort {
  private int[] list;

  public InsertionSort(int[] list) {
    this.list = list;
  }

  /**
   * Time Complexity -> O(N^2)
   * Space Complexity -> O(1)
   * 
   * Very efficient for arrays of length less than 15 or for almost sorted arrays.
   * 
   * Used with merge sort in TimSort which is used in Java's sorting method
   * Arrays.sort.
   */
  @Override
  public int[] sort() {
    for (int i = 0; i < list.length; i++) {
      int j = i;
      while (j > 0) {
        if (list[j] > list[j - 1])
          break;
        swap(j, j - 1);
        j--;
      }
    }

    return list;

  }

  private void swap(int i, int j) {
    if (i < 0 || j < 0 || i >= list.length || j >= list.length)
      throw new RuntimeException("Invalid indices");

    var temp = list[i];
    list[i] = list[j];
    list[j] = temp;

  }
}
