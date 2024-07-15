package sort;

import java.util.Arrays;

public class MergeSort extends Sort {

    public MergeSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        mergeSort(this.integerGroup, 0, this.integerGroup.length - 1);
    }

    private void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2;
            mergeSort(arr, startIndex, middle);
            mergeSort(arr, middle + 1, endIndex);
            merge(arr, startIndex, middle, endIndex);
        }
    }

    private void merge(int[] arr, int startIndex, int middle, int endIndex) {
        int[] leftArray = Arrays.copyOfRange(arr, startIndex, middle + 1);
        int[] rightArray = Arrays.copyOfRange(arr, middle + 1, endIndex + 1);

        int i = 0, j = 0, k = startIndex;
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
