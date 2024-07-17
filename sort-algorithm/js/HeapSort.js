class HeapSort extends Sort {
    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 힙을 생성합니다. 배열의 중간부터 시작하여 첫 요소까지 힙을 구성합니다.
        for (let i = (this.numberGroup.length / 2 - 1); i >= 0; i--) {
            this.heapify(this.numberGroup, this.numberGroup.length, i);
        }
        // 힙에서 하나씩 요소를 추출하여 정렬합니다.
        for (let i = this.numberGroup.length - 1; i > 0; i--) {
            super.swap(this.numberGroup, 0, i); // 현재 루트(최대값)를 배열의 끝으로 이동시킵니다.
            this.heapify(this.numberGroup, i, 0); // 루트에서부터 힙을 재구성합니다.
        }
    }

    // 힙을 구성하는 메서드입니다.
    heapify(arr, length, index) {
        let largestIndex = index; // 현재 루트를 가장 큰 값으로 가정합니다.
        const left = 2 * index + 1; // 왼쪽 자식의 인덱스
        const right = 2 * index + 2; // 오른쪽 자식의 인덱스

        // 왼쪽 자식이 루트보다 크다면 왼쪽 자식을 가장 큰 값으로 설정합니다.
        if (left < length && arr[left] > arr[largestIndex]) {
            largestIndex = left;
        }

        // 오른쪽 자식이 현재 가장 큰 값보다 크다면 오른쪽 자식을 가장 큰 값으로 설정합니다.
        if (right < length && arr[right] > arr[largestIndex]) {
            largestIndex = right;
        }

        // 가장 큰 값이 루트가 아니라면 교환하고, 재귀적으로 힙을 구성합니다.
        if (largestIndex !== index) {
            super.swap(arr, index, largestIndex);
            this.heapify(arr, length, largestIndex);
        }
    }
}