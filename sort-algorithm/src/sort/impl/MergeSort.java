package sort.impl;

import sort.abs.NLogNSort;

import java.util.Arrays;

public class MergeSort extends NLogNSort {

    public MergeSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 병합 정렬을 수행합니다. 배열 전체를 정렬 대상으로 지정합니다.
        mergeSort(this.integerGroup, 0, this.integerGroup.length - 1);
    }

    // 병합 정렬 알고리즘의 메인 로직입니다
    private void mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int middle = (startIndex + endIndex) / 2; // 중간 인덱스를 계산합니다.
            mergeSort(arr, startIndex, middle); // 왼쪽 절반을 정렬합니다.
            mergeSort(arr, middle + 1, endIndex); // 오른쪽 절반을 정렬합니다.
            merge(arr, startIndex, middle, endIndex); // 정렬된 두 절반을 병합합니다.
        }
    }

    // 두 정렬된 하위 배열을 병합하는 메서드입니다.
    private void merge(int[] arr, int startIndex, int middle, int endIndex) {
        // 왼쪽 하위 배열을 복사합니다.
        int[] leftArray = Arrays.copyOfRange(arr, startIndex, middle + 1);
        // 오른쪽 하위 배열을 복사합니다.
        int[] rightArray = Arrays.copyOfRange(arr, middle + 1, endIndex + 1);

        int i = 0;
        int j = 0;
        int k = startIndex;

        // 두 하위 배열을 병합하여 정렬된 배열을 만듭니다.
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

        // 왼쪽 배열에 남아있는 요소들을 복사합니다.
        while (i < leftArray.length) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // 오른쪽 배열에 남아있는 요소들을 복사합니다.
        while (j < rightArray.length) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}
