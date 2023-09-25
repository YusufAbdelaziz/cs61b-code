package sortingAlgos;

import java.util.Arrays;

public class CountingSort implements Sort {
  private int[] list;

  public CountingSort(int[] list) {
    this.list = list;
  }

  public CountingSort() {
    this.list = null;
  }

  @Override
  public int[] sort() {
    if (this.list == null)
      throw new RuntimeException("List is not initialized");
    // O(N + R) where R is the alphabet which is basically the the max element.
    int max = Arrays.stream(list).max().getAsInt();
    int[] count = new int[max + 1];
    int[] output = new int[list.length];

    for (int i = 0; i < list.length; i++) {
      count[list[i]]++;
    }
    // Find accumulative count to know where to insert elements in correct order.
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = output.length - 1; i >= 0; i--) {
      output[count[list[i]] - 1] = list[i];
      count[list[i]]--;
    }
    return output;
  }

  // Using counting sort for Radix Sorting.
  public void sort(int[] list, int place) {
    // O(N + R) where R is the alphabet which is basically the the max element.
    int max = Arrays.stream(list).max().getAsInt();
    int[] count = new int[max + 1];
    int[] output = new int[list.length];

    for (int i = 0; i < list.length; i++) {
      count[(list[i] / place) % 10]++;
    }
    // Find accumulative count to know where to insert elements in correct order.
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    for (int i = output.length - 1; i >= 0; i--) {
      output[count[(list[i] / place) % 10] - 1] = list[i];
      count[(list[i] / place) % 10]--;
    }
    for (int i = 0; i < list.length; i++) {
      list[i] = output[i];
    }
  }

}
