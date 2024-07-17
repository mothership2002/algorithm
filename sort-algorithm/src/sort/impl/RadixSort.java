package sort.impl;

import sort.Sort;

import java.util.Arrays;

/**
 * O(d×(n+k))
 */
public class RadixSort extends Sort {

    public RadixSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        // 배열에서 가장 큰 값을 구합니다.
        int max = getMax();
        // 자릿수(exp)별로 정렬을 수행합니다. 1의 자리, 10의 자리, 100의 자리 등.
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(integerGroup, exp);
        }
    }

    // 자릿수(exp)를 기준으로 배열을 정렬하는 계수 정렬 메서드입니다.
    private void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n]; // 정렬된 결과를 저장할 배열입니다.
        int[] count = new int[10]; // 자릿수(0-9)별로 요소의 개수를 세기 위한 배열입니다.
        Arrays.fill(count, 0); // count 배열을 0으로 초기화합니다.

        // 각 자릿수에 해당하는 요소의 개수를 셉니다.
        for (int j : arr) {
            count[(j / exp) % 10]++;
        }

        // 누적합을 구합니다. 이를 통해 요소의 정렬된 위치를 계산합니다.
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 요소들을 출력 배열에 정렬된 순서로 삽입합니다.
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // 정렬된 결과를 원래 배열에 복사합니다.
        System.arraycopy(output, 0, arr, 0, n);
    }
}