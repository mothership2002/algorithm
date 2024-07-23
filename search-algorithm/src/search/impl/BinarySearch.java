package search.impl;

import module.RandomModule;
import search.Search;

public class BinarySearch extends Search {
    public BinarySearch(int count) {
        super();
        // for binary search
        integerGroup = RandomModule.getArrayForBinarySearch(count);
        getListOne();
    }

    @Override
    protected void searching(int keyword) {
        int low = 0;
        int high = integerGroup.length - 1;

        try {
            while (low <= high) {
                int middle = (low + high) / 2;
                if (integerGroup[middle] < keyword) {
                    low = middle + 1;
                } else if (integerGroup[middle] > keyword) {
                    high = middle - 1;
                } else {
                    System.out.println(INDEX + middle);
                    return;
                }
            }

        } catch (RuntimeException e) {
            notFoundKeyword();
        }
    }

}
