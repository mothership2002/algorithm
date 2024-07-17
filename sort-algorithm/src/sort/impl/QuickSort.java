package sort.impl;

import sort.abs.NLogNSort;

/**
 * O(n log n)
 */
public class QuickSort extends NLogNSort {

    public QuickSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 퀵 정렬을 수행합니다. 배열 전체를 정렬 대상으로 지정합니다.
        quickSorting(integerGroup, 0, integerGroup.length - 1);
    }

    // 퀵 정렬 알고리즘의 메인 로직입니다.
    private void quickSorting(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            // 배열을 분할하여 피벗을 기준으로 정렬합니다.
            int partitionPoint = partition(array, startIndex, endIndex);
            // 피벗 기준 왼쪽 부분 배열을 재귀적으로 정렬합니다.
            quickSorting(array, startIndex, partitionPoint - 1);
            // 피벗 기준 오른쪽 부분 배열을 재귀적으로 정렬합니다.
            quickSorting(array, partitionPoint + 1, endIndex);
        }
    }

    // 피벗 인덱스를 결정하는 메서드입니다. 첫 번째, 중간, 마지막 값 중에서 중간값을 선택합니다.
    private int getPivotIndex(int[] array, int startIndex, int endIndex) {
        int midIndex = startIndex + (endIndex - startIndex) / 2;
        int startValue = array[startIndex];
        int midValue = array[midIndex];
        int endValue = array[endIndex];

        // 중간값을 선택하는 로직입니다.
        if ((startValue > midValue) != (startValue > endValue)) {
            return startIndex;
        } else if ((midValue > startValue) != (midValue > endValue)) {
            return midIndex;
        } else {
            return endIndex;
        }
    }

    // 배열을 피벗을 기준으로 분할하는 메서드입니다.
    private int partition(int[] array, int startIndex, int endIndex) {
        int pivotIndex = getPivotIndex(array, startIndex, endIndex);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, endIndex);  // 피벗을 끝으로 이동시킵니다.
        int storeIndex = startIndex;

        // 피벗보다 작은 모든 요소들을 피벗의 왼쪽으로 이동시킵니다.
        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] < pivot) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        // 피벗을 최종 위치로 이동시킵니다.
        swap(array, storeIndex, endIndex);
        return storeIndex; // 피벗의 최종 위치를 반환합니다.
    }
}
