package search.impl;

import search.Search;


public class LinearSearch extends Search {

    public LinearSearch(int count) {
        super(count);
    }


    @Override
    protected void searching(int keyword) {
        for (int i : integerGroup) {
            if (i == keyword) {
                break;
            }
        }
    }
}
