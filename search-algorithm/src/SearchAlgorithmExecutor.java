import abs.Algorithm;
import module.ClassExplorer;
import search.Search;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SearchAlgorithmExecutor {

    private static final String PACKAGE = "search.impl";
    private static final String POSTFIX = "Search";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("put in array length : ");
        int count = Integer.parseInt(scanner.nextLine());

        System.out.print("put in search algorithm : ");
        String name = scanner.nextLine();

        // init
        Set<Class<?>> classList = ClassExplorer.getClassList(PACKAGE);
        Map<String, Algorithm> map = ClassExplorer.init(classList, count, POSTFIX, name);
        System.out.print("put in you want to find one : ");
        String keyword = scanner.nextLine();

        // execute
        map.values().stream()
                .map(algorithm -> (Search) algorithm)
                .forEach(search -> search.search(Integer.parseInt(keyword)));

    }


}