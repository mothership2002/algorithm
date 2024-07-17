package sort.impl;

import sort.abs.NDoubleSquareSort;

public class InsertSort extends NDoubleSquareSort {

    public InsertSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 배열의 두 번째 요소부터 시작하여 끝까지 순회합니다.
        for (int i = 1; i < integerGroup.length; i++) {
            int key = integerGroup[i]; // 현재 요소를 key로 설정합니다.
            int j = i - 1;

            // 현재 요소보다 큰 요소들을 오른쪽으로 한 칸씩 이동시킵니다.
            while (j >= 0 && integerGroup[j] > key) {
                integerGroup[j + 1] = integerGroup[j];
                j--;
            }

            // 현재 요소를 올바른 위치에 삽입합니다.
            integerGroup[j + 1] = key;
        }
    }
}
