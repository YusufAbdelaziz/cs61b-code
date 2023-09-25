package sortingAlgos;

import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    int[] arr = new int[] { 2, 3, 6, 5, 4, 1, 7 };

    SelectionSort selectionSort = new SelectionSort(Arrays.copyOf(arr, arr.length));
    System.out.println("Selection Sort -> " + Arrays.toString(selectionSort.sort()));

    HeapSort heapSort = new HeapSort(Arrays.copyOf(arr, arr.length));
    System.out.println("HeapSort (Naive) -> " + Arrays.toString(heapSort.naiveSort()));
    System.out.println("HeapSort (Efficient) -> " + Arrays.toString(heapSort.sort()));

    MergeSort mergeSort = new MergeSort(Arrays.copyOf(arr, arr.length));
    System.out.println("MergeSort  -> " + Arrays.toString(mergeSort.sort()));

    InsertionSort insertionSort = new InsertionSort(Arrays.copyOf(arr, arr.length));
    System.out.println("InsertionSort  -> " + Arrays.toString(insertionSort.sort()));

    QuickSort quickSort = new QuickSort(Arrays.copyOf(arr, arr.length));
    System.out.println("QuickSort  -> " + Arrays.toString(quickSort.sort()));

    CountingSort countingSort = new CountingSort(Arrays.copyOf(arr, arr.length));
    System.out.println("CountingSort  -> " + Arrays.toString(countingSort.sort()));

    RadixSort radixSort = new RadixSort(new int[] { 121, 432, 564, 23, 1, 45, 788 });
    System.out.println("RadixSort  -> " + Arrays.toString(radixSort.sort()));
  }
}
