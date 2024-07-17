class RadixSort extends Sort {

    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 배열에서 가장 큰 값을 구합니다.
        let max = this.getMax();
        // 자릿수(exp)별로 정렬을 수행합니다. 1의 자리, 10의 자리, 100의 자리 등.
        for (let exp = 1; max / exp > 0; exp *= 10) {
            this.countSort(this.numberGroup, exp);
        }
    }

    getMax() {
        let max = this.numberGroup[0];
        for (let i = 1; i < this.numberGroup.length; i++) {
            if (this.numberGroup[i] > max) {
                max = this.numberGroup[i];
            }
        }
        return max;
    }

    countSort(array, exp) {
        let output = new Array(array.length); // 정렬된 결과를 저장할 배열입니다.
        let count = new Array(10).fill(0);// 자릿수(0-9)별로 요소의 개수를 세기 위한 배열입니다. count 배열을 0으로 초기화합니다.

        // 각 자릿수에 해당하는 요소의 개수를 셉니다.
        for (let i = 0; i < array.length; i++) {
            count[Math.floor(array[i] / exp) % 10]++;
        }

        // 누적합을 구합니다. 이를 통해 요소의 정렬된 위치를 계산합니다.
        for (let i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 요소들을 출력 배열에 정렬된 순서로 삽입합니다.
        for (let i = array.length - 1; i >= 0; i--) {
            output[count[Math.floor(array[i] / exp) % 10] - 1] = array[i];
            count[Math.floor(array[i] / exp) % 10]--;
        }

        // 정렬된 결과를 원래 배열에 복사합니다.
        for (let i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}