package sortingAlgos;

public class MergeSort implements Sort {
  private int[] list;

  public MergeSort(int[] list) {
    this.list = list;
  }

  /**
   * Time Complexity -> O(NlogN)
   * Space Complexity -> O(N)
   */
  @Override
  public int[] sort() {
    mergeSort(list, 0, list.length - 1);

    return list;
  }

  private void mergeSort(int[] list, int startIndex, int endIndex) {
    if (startIndex < endIndex) {
      int middleIndex = startIndex + (endIndex - startIndex) / 2;
      mergeSort(list, startIndex, middleIndex);
      mergeSort(list, middleIndex + 1, endIndex);
      merge(list, startIndex, middleIndex, endIndex);

    }
  }

  private void merge(int[] list, int startIndex, int middleIndex, int endIndex) {

    int firstArrayLength = middleIndex - startIndex + 1;
    int secondArrayLength = endIndex - middleIndex;

    int[] tempFirstArr = new int[firstArrayLength];
    int[] tempSecondArr = new int[secondArrayLength];

    // Copy first portion of the list into tempFirstArr.
    for (int i = 0; i < firstArrayLength; i++) {
      tempFirstArr[i] = list[i + startIndex];
    }
    // Copy second portion of the list into tempSecondArr.
    for (int i = 0; i < secondArrayLength; i++) {
      tempSecondArr[i] = list[middleIndex + 1 + i];
    }
    // Initial index of merged list.
    int k = startIndex;
    int i = 0, j = 0;
    while (i < firstArrayLength && j < secondArrayLength) {
      if (tempFirstArr[i] <= tempSecondArr[j]) {
        list[k] = tempFirstArr[i];
        i++;
      } else {
        list[k] = tempSecondArr[j];
        j++;
      }

      k++;
    }

    // If second portion is exhausted and the first portion has some items left,
    // just copy them into
    // merged array.
    while (i < firstArrayLength) {
      list[k] = tempFirstArr[i];
      i++;
      k++;
    }

    while (j < secondArrayLength) {
      list[k] = tempSecondArr[j];
      j++;
      k++;
    }
  }

}
