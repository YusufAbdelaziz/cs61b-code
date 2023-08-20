package sortingAlgos;

public class SelectionSort implements Sort {
  private int[] list;

  public SelectionSort(int[] list) {
    this.list = list;
  }

  /**
   * Time Complexity -> O(N^2)
   * Space Complexity -> O(1)
   * 
   * 
   */
  @Override
  public int[] sort() {
    for (int i = 0; i < list.length; i++) {
      int smallestIndex = i;
      for (int j = i + 1; j < list.length; j++) {
        if (list[j] < list[smallestIndex]) {
          smallestIndex = j;
        }
      }
      var temp = list[i];
      list[i] = list[smallestIndex];
      list[smallestIndex] = temp;
    }
    return list;
  }

}
