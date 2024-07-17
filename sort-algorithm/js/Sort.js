class Sort {
    numberGroup = [];
    constructor(count) {
        for (let i = 0; i < count; i++) {
            this.numberGroup.push(i);
        }
        this.shuffle(this.numberGroup);
    }

    shuffle(array) {
        for (let i = array.length - 1; i > 0; i--) {
            let j = Math.floor(Math.random() * (i + 1));
            [array[i], array[j]] = [array[j], array[i]];
        }
    }

    sort(sorting) {
        console.time("Sorting time");
        sorting();
        console.timeEnd("Sorting time");
    }

    swap(array, i, j) {
        const temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    getNumberGroup() {
        return this.numberGroup;
    }
}