package sort.impl;

import sort.Sort;

import java.util.Arrays;

public class CountingSort extends Sort {
    public CountingSort(int count) {
        super(count);
    }

    /**
     * 중복값이 없고 최대값이 길이의 -1이므로 값의 범위가 정해져있다.
     * 그러므로 계수정렬로 정렬이 가능하다.
     */
    @Override
    protected void sorting() {
        int min = getMin();
        int max = getMax();

        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[range];

        // 카운팅 배열 초기화
        for (int j : integerGroup) {
            count[j - min]++;
        }
        
        // 카운트 횟수 체크
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // output 배열 생성
        for (int i = integerGroup.length - 1; i >= 0; i--) {
            output[count[integerGroup[i] - min] - 1] = integerGroup[i];
            count[integerGroup[i] - min]--;
        }
        System.arraycopy(output, 0, integerGroup, 0, integerGroup.length);
    }

}
