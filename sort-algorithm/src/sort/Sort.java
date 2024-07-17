package sort;

import sort.component.RandomModule;

import java.util.Arrays;

public abstract class Sort {
    protected int[] integerGroup;
    protected long startTime;
    protected long endTime;

    public Sort(int count) {
        integerGroup = RandomModule.getArray(count);
    }

    public void sort() {
        startTime = System.nanoTime();
        sorting();
        endTime = System.nanoTime();
        double durationMs = ((double) (endTime - startTime) / 1_000_000);
        System.out.println("[소요시간] : " + durationMs + "ms");
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
