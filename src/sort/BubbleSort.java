package sort;

public class BubbleSort extends Sort {

    public BubbleSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        for (int i = 0; i < this.integerGroup.length; i++) {
            for (int j = 0; j < this.integerGroup.length - i - 1; j++) {
                if (this.integerGroup[j] > this.integerGroup[j + 1]) {
                    swap(this.integerGroup, j, j + 1);
                }
            }
        }
    }
}
