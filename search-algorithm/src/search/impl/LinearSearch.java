package search.impl;

import search.Search;


public class LinearSearch extends Search {

    public LinearSearch(int count) {
        super(count);
    }

    @Override
    protected void searching(int keyword) {
        for (int i = 0; i < integerGroup.length; i++) {
            if (integerGroup[i] == keyword) {
                System.out.println(INDEX + i);
                return;
            }
        }
        notFoundKeyword();
    }
}
