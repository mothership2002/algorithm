import sort.BubbleSort;
import sort.MergeSort;
import sort.QuickSort;
import sort.Sort;

public class Main {
    private final static String INIT = "초기 값";
    private final static String END = "정렬 값";

    public static void main(String[] args) {
        int count = 30;
        print(new BubbleSort(count));
        print(new QuickSort(count));
        print(new MergeSort(count));
    }

    public static void print(Sort sort) {
        System.out.println("=======================================");
        System.out.println(sort.getClass());
        sort.printIntegerGroup(INIT);
        sort.sort();
        sort.printIntegerGroup(END);
    }
}