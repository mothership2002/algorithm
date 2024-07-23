import abs.Algorithm;
import module.ClassExplorer;
import search.SearchAlgorithm;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class SearchAlgorithmExecutor {

    private static final String PACKAGE = "search.impl";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("put in array length : ");
        int count = 50;
        try {
            count = Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException ignored) {
        }
        System.out.println("elemental count : " + count);
        System.out.print("put in search algorithm : ");
        String name = scanner.nextLine();

        // init
        Set<Class<?>> classList = ClassExplorer.getClassList(PACKAGE);
        List<Algorithm> list = ClassExplorer.init(classList, count, name);
        System.out.print("put in you want to find one : ");
        String keyword = scanner.nextLine();

        // execute
        list.stream()
                .map(algorithm -> (SearchAlgorithm) algorithm)
                .forEach(search -> search.run(Integer.parseInt(keyword)));

    }


}