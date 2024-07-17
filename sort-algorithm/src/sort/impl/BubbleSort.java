package sort.impl;

import sort.abs.NDoubleSquareSort;

public class BubbleSort extends NDoubleSquareSort {

    public BubbleSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 배열의 처음부터 끝까지 순회합니다.
        for (int i = 0; i < this.integerGroup.length; i++) {
            // 배열의 끝에서부터 정렬되지 않은 부분까지 순회합니다.
            for (int j = 0; j < this.integerGroup.length - i - 1; j++) {
                // 인접한 두 요소를 비교하여 순서가 잘못되었으면 교환합니다.
                if (this.integerGroup[j] > this.integerGroup[j + 1]) {
                    swap(this.integerGroup, j, j + 1);
                }
            }
        }
    }
}
