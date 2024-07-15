package sort;

public class QuickSort extends Sort {

    public QuickSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        quickSorting(integerGroup, 0, integerGroup.length - 1);
    }

    private void quickSorting(int[] array, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int partitionPoint = partition(array, startIndex, endIndex);
            quickSorting(array, startIndex, partitionPoint - 1);
            quickSorting(array, partitionPoint + 1, endIndex);
        }
    }

    private int getPivotIndex(int startIndex, int endIndex) {
        return startIndex + RandomModule.getNumber(endIndex - startIndex);
    }

    private int partition(int[] array, int startIndex, int endIndex) {
        int pivotIndex = getPivotIndex(startIndex, endIndex);
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, endIndex);
        int storeIndex = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (array[i] < pivot) {
                swap(array, i, storeIndex);
                storeIndex++;
            }
        }
        swap(array, storeIndex, endIndex);
        return storeIndex;
    }
}
