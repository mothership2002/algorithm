package search;

import abs.Algorithm;
import module.RandomModule;

public abstract class Search implements Algorithm {

    protected final String INDEX = "Keyword found at index : ";
    protected final String LAST_ONE = "last one : ";
    protected int[] integerGroup;
    protected long startTime;
    protected long endTime;

    public Search() {
    }

    public Search(int count) {
        integerGroup = RandomModule.getArray(count);
        getListOne();
    }

    public void search(int keyword) {
        startTime = System.nanoTime();
        searching(keyword);
        endTime = System.nanoTime();
        double durationMs = ((double) (endTime - startTime) / 1_000_000);
        System.out.println(DURATION + durationMs + MILLISECOND);
    }

    protected abstract void searching(int keyword);

    protected void getListOne() {
        System.out.println(LAST_ONE + integerGroup[integerGroup.length - 1]);
    }

    protected void notFoundKeyword() {
        System.out.println("not found keyword");
    }
}
