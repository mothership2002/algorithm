package sort.impl;

import sort.SortAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort extends SortAlgorithm {

    public BucketSort(int count) {
        super(count);
    }

    @Override
    protected void sorting() {
        bucketSort();
    }

    private void bucketSort() {
        int min = getMin();
        int max = getMax();

        int bucketCount = (max - min) / integerGroup.length + 1;
        ArrayList<Integer>[] buckets = new ArrayList[bucketCount];
        for (int i = 0; i < bucketCount; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int j : integerGroup) {
            int bucketIndex = (j - min) / integerGroup.length;
            buckets[bucketIndex].add(j);
        }

        int currentIndex = 0;
        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
            for (Integer integer : bucket) {
                integerGroup[currentIndex++] = integer;
            }
        }
    }
}
