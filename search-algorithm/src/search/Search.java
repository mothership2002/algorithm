package search;

import module.RandomModule;

public abstract class Search {

    protected int[] integerGroup;
    protected long startTime;
    protected long endTime;

    public Search(int count) {
        integerGroup = RandomModule.getArray(count);
    }

    protected void search() {
        startTime = System.nanoTime();
        searching();
        endTime = System.nanoTime();
        double durationMs = ((double) (endTime - startTime) / 1_000_000);
        System.out.println("[소요 시간] : " + durationMs + "ms");
    }

    protected abstract void searching();
}
