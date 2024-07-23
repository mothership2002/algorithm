import abs.Algorithm;
import graph.GraphSearch;
import module.ClassExplorer;

import java.util.List;
import java.util.Scanner;

public class GraphSearchAlgorithmExecutor {

    private static final String PACKAGE = "graph.impl";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("put in array length : ");
        int count = 50;
        try {
            count = Integer.parseInt(scanner.nextLine());
        } catch (RuntimeException ignored) {
        }
        System.out.println("elemental count : " + count);
        List<Class<?>> classList = ClassExplorer.getClassList(PACKAGE).stream().toList();

        for (int i = 0, classListSize = classList.size(); i < classListSize; i++) {
            System.out.println(i + 1 + ". " + classList.get(i).getSimpleName());
        }

        System.out.print("put in search algorithm Number : ");
        String inputIndex = scanner.nextLine();
        String simpleName = "all";
        try {
            simpleName = classList.get(Integer.parseInt(inputIndex)).getSimpleName();
        } catch (RuntimeException ignored) {
        }

        // init
        List<Algorithm> list = ClassExplorer.init(classList, count, simpleName);
        System.out.print("put in you want to find one : ");
        String keyword = scanner.nextLine();

        // execute
        list.stream()
                .map(algorithm -> (GraphSearch) algorithm)
                .forEach(search -> search.run(Integer.parseInt(keyword)));

    }
}
