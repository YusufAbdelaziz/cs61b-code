package sortingAlgos;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * QuickSort using Hoare's Partitioning scheme.
 */
public class QuickSort implements Sort {
  private int[] list;

  public QuickSort(int[] list) {
    this.list = list;
  }

  @Override
  public int[] sort() {
    var shuffledList = shuffle(list);
    quickSort(0, shuffledList.length - 1, shuffledList);
    return shuffledList;
  }

  private void quickSort(int l, int h, int[] list) {
    if (l < h) {
      int pivotCorrectIndex = hoarePartition(l, h, list);
      quickSort(l, pivotCorrectIndex, list);
      quickSort(pivotCorrectIndex + 1, h, list);
    }

  }

  private int hoarePartition(int low, int high, int[] list) {
    int pivot = list[low];
    int L = low + 1; // Less than pointer.
    int G = high; // Greater than pointer

    while (true) {
      // It may happen that L passes the last element in the array.
      // This happens when the right partition is the last element in the array.
      while (list[L] < pivot && L < G) {
        L++;
      }

      while (list[G] > pivot) {
        G--;
      }

      // Pointer cross
      if (L >= G) {
        // Swap the pivot with pointer G.
        int temp = list[low];
        list[low] = list[G];
        list[G] = temp;
        return G;
      }

      int temp = list[L];
      list[L] = list[G];
      list[G] = temp;

    }
  }

  private int[] shuffle(int[] list) {
    List<Integer> intList = Arrays.stream(list).boxed().collect(Collectors.toList());
    Collections.shuffle(intList);
    return intList.stream().mapToInt(Integer::intValue).toArray();
  }
}
