package search;

import abs.Algorithm;
import module.RandomModule;

public abstract class Search implements Algorithm {

    protected int[] integerGroup;
    protected long startTime;
    protected long endTime;

    public Search(int count) {
        integerGroup = RandomModule.getArray(count);
        System.out.println("last one : " + integerGroup[integerGroup.length - 1]);
    }

    public void search(int keyword) {
        startTime = System.nanoTime();
        searching(keyword);
        endTime = System.nanoTime();
        double durationMs = ((double) (endTime - startTime) / 1_000_000);
        System.out.println("[duration] : " + durationMs + "ms");
    }

    protected abstract void searching(int keyword);
}
