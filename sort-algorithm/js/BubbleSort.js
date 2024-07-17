class BubbleSort extends Sort {

    constructor(count){
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 배열의 처음부터 끝까지 순회합니다.
        for (let i = 0; i < this.numberGroup.length; i++) {
            // 배열의 끝에서부터 정렬되지 않은 부분까지 순회합니다.
            for (let j = 0; j < this.numberGroup.length - i - 1; j++) {
                // 인접한 두 요소를 비교하여 순서가 잘못되었으면 교환합니다.
                if (this.numberGroup[j] > this.numberGroup[j + 1]) {
                    super.swap(this.numberGroup, j, j + 1);
                }
            }
        }
    }
}