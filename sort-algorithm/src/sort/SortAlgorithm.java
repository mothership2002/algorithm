package sort;

import abs.Algorithm;
import module.RandomModule;

import java.util.Arrays;

public abstract class SortAlgorithm extends Algorithm {
    protected int[] integerGroup;

    public SortAlgorithm(int count) {
        integerGroup = RandomModule.getArray(count);
    }

    public void printIntegerGroup(String name) {
        System.out.print("[" + name + "] : ");
        System.out.println(Arrays.toString(integerGroup));
    }

    protected abstract void sorting();

    protected void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    protected int getMin() {
        return Arrays.stream(integerGroup).min().orElseThrow(RuntimeException::new);
    }

    protected int getMax() {
        return Arrays.stream(integerGroup).max().orElseThrow(RuntimeException::new);
    }

}
