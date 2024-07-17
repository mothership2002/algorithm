class InsertSort extends Sort {

    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this))
    }

    sorting() {
        // 배열의 두 번째 요소부터 시작하여 끝까지 순회합니다.
        for (let i = 1; i < this.numberGroup.length; i++) {
            const key = this.numberGroup[i]; // 현재 요소를 key로 설정합니다.
            let j = i - 1;

            // 현재 요소보다 큰 요소들을 오른쪽으로 한 칸씩 이동시킵니다.
            while (j >= 0 && this.numberGroup[j] > key) {
                this.numberGroup[j + 1] = this.numberGroup[j];
                j--;
            }
            // 현재 요소를 올바른 위치에 삽입합니다.
            this.numberGroup[j + 1] = key;
        }
    }
}