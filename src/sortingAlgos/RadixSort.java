package sortingAlgos;

import java.util.Arrays;

public class RadixSort implements Sort {
  private int[] list;

  public RadixSort(int[] list) {
    this.list = list;
  }

  @Override
  public int[] sort() {
    CountingSort countingSort = new CountingSort();
    int max = Arrays.stream(list).max().getAsInt();
    for (int place = 1; max / place > 0; place *= 10) {
      countingSort.sort(list, place);
    }
    return list;
  }

}
