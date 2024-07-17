package sort.impl;

import sort.abs.NDoubleSquareSort;

public class SelectSort extends NDoubleSquareSort {

    public SelectSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 배열의 처음부터 끝까지 순회합니다.
        for (int i = 0; i < integerGroup.length; i++) {
            int minIndex = i; // 현재 인덱스를 최소값의 인덱스로 초기화합니다.

            // 현재 인덱스 이후의 요소들 중에서 최소값을 찾습니다.
            for (int j = i + 1; j < integerGroup.length; j++) {
                if (integerGroup[j] < integerGroup[minIndex]) {
                    minIndex = j; // 최소값의 인덱스를 업데이트합니다.
                }
            }

            // 현재 요소와 최소값 요소를 교환합니다.
            swap(integerGroup, i, minIndex);
        }
    }
}
