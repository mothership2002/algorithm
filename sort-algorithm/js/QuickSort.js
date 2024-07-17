class QuickSort extends Sort {

    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 퀵 정렬을 수행합니다. 배열 전체를 정렬 대상으로 지정합니다.
        this.quickSort(this.numberGroup, 0, this.numberGroup.length - 1);
    }

    quickSort(array, startIndex, endIndex) {
        if (startIndex < endIndex) {
            // 배열을 분할하여 피벗을 기준으로 정렬합니다.
            const partitionPoint = this.partition(array, startIndex, endIndex);
            // 피벗 기준 왼쪽 부분 배열을 재귀적으로 정렬합니다.
            this.quickSort(array, startIndex, partitionPoint - 1);
            // 피벗 기준 오른쪽 부분 배열을 재귀적으로 정렬합니다.
            this.quickSort(array, partitionPoint + 1, endIndex);
        }
    }

    partition(array, startIndex, endIndex) {
        const pivotIndex = this.getPivotIndex(array, startIndex, endIndex);
        const pivot = array[pivotIndex];
        super.swap(array, pivotIndex, endIndex);  // 피벗을 끝으로 이동시킵니다.
        let storeIndex = startIndex;

        // 피벗보다 작은 모든 요소들을 피벗의 왼쪽으로 이동시킵니다.
        for (let i = startIndex; i < endIndex; i++) {
            if (array[i] < pivot) {
                super.swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        // 피벗을 최종 위치로 이동시킵니다.
        super.swap(array, storeIndex, endIndex);
        return storeIndex; // 피벗의 최종 위치를 반환합니다.
    }

    getPivotIndex(array, startIndex, endIndex) {
        const midIndex = startIndex + (endIndex - startIndex) / 2;
        const startValue = array[startIndex];
        const midValue = array[midIndex];
        const endValue = array[endIndex];

        // 중간값을 선택하는 로직입니다.
        if ((startValue > midValue) !== (startValue > endValue)) {
            return startIndex;
        } else if ((midValue > startValue) !== (midValue > endValue)) {
            return midIndex;
        } else {
            return endIndex;
        }
    }
}