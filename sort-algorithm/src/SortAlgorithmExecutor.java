import abs.Algorithm;
import module.ClassExplorer;
import sort.Sort;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class SortAlgorithmExecutor {

    private final static String INIT = "초기 값";
    private final static String END = "정렬 값";
    private final static boolean FLAG = false;
    private static final String PACKAGE = "sort.impl";
    private static final String POSTFIX = "Sort";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("input select count : ");
        int count = 50;
        try {
            count = Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException ignored) {
        }
        System.out.println("elemental count : " + count);
        System.out.print("input sort name : ");
        print(scanner.nextLine(), count);
    }

    public static void print(Algorithm algorithm) {
        System.out.println("=======================================");
        Sort sort = (Sort) algorithm;
        System.out.println(sort.getClass().getSuperclass().getSimpleName() + " / " + sort.getClass().getSimpleName());
        print(sort, INIT);
        sort.sort();
        print(sort, END);
    }

    private static void print(Sort sort, String text) {
        if (FLAG) {
            sort.printIntegerGroup(text);
        }
    }

    private static void print(String name, int count) {
        Set<Class<?>> classList = ClassExplorer.getClassList(PACKAGE);
        List<Algorithm> list = ClassExplorer.init(classList, count, POSTFIX, name);
        list.forEach(SortAlgorithmExecutor::print);
    }


}