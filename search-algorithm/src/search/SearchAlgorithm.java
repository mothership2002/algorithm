package search;

import abs.Algorithm;
import module.RandomModule;

public abstract class SearchAlgorithm extends Algorithm {

    protected final String INDEX = "Keyword found at index : ";
    protected final String LAST_ONE = "last one : ";
    protected int[] integerGroup;


    public SearchAlgorithm() {
    }

    public SearchAlgorithm(int count) {
        integerGroup = RandomModule.getArray(count);
        getListOne();
    }

    protected void getListOne() {
        System.out.println(LAST_ONE + integerGroup[integerGroup.length - 1] + " / " + this.getClass().getSimpleName());
    }

    protected void notFoundKeyword() {
        System.out.println("not found keyword");
    }
}
