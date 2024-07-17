class ShellSort extends Sort {
    constructor(count) {
        super(count);
    }

    sort() {
        super.sort(this.sorting.bind(this));
    }

    sorting() {
        // 초기 i를 배열 길이의 절반으로 설정하고, i을 반복마다 반으로 줄여 나갑니다.
        for (let i = Math.floor(this.numberGroup.length / 2); i > 0; i /= 2) {
            // 현재 i의 인덱스부터 배열 끝까지 순회합니다
            for (let j = i; j < this.numberGroup.length; j++) {
                const key = this.numberGroup[j]; // 현재 요소를 key로 설정합니다.
                let z;
                // 현재 요소와 i 만큼 떨어진 이전 요소들을 비교하여 삽입할 위치를 찾습니다.
                for (z = j; z >= i && this.numberGroup[z - i] > key; z -= i) {
                    this.numberGroup[z] = this.numberGroup[z - i]; // 요소를 한 칸씩 뒤로 이동시킵니다.
                }
                this.numberGroup[z] = key; // key를 올바른 위치에 삽입합니다.
            }
        }
    }
}