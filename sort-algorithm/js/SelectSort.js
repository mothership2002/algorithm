class SelectSort extends Sort {

    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 배열의 처음부터 끝까지 순회합니다.
        for (let i = 0; i < this.numberGroup.length; i++) {
            let minIndex = i; // 현재 인덱스를 최소값의 인덱스로 초기화합니다.

            // 현재 인덱스 이후의 요소들 중에서 최소값을 찾습니다.
            for (let j = i + 1; j < this.numberGroup.length; j++) {
                if (this.numberGroup[j] < this.numberGroup[minIndex]) {
                    minIndex = j; // 최소값의 인덱스를 업데이트합니다.
                }
            }

            // 현재 요소와 최소값 요소를 교환합니다.
            super.swap(this.numberGroup, i, minIndex);
        }
    }
}