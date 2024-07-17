import sort.Sort;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

public class Main {
    private final static String INIT = "초기 값";
    private final static String END = "정렬 값";
    private final static boolean FLAG = true;
    private static final String PACKAGE = "sort.impl";
    private static final String POSTFIX = "Sort";
    private static final String BLANK = "";
    private static final String DOT = ".";

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

    public static void print(Sort sort) {
        System.out.println("=======================================");
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
        Map<String, Sort> sortMap = new HashMap<>();
        Set<Class<?>> classList = getClassList(PACKAGE);
        for (Class<?> clazz : classList) {
            try {
                sortMap.put(clazz.getSimpleName().replace(POSTFIX, BLANK).toLowerCase(), (Sort) clazz.getDeclaredConstructor(int.class).newInstance(count));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }

        if (sortMap.containsKey(name)) {
            print(sortMap.get(name));
        } else {
            sortMap.values().forEach(Main::print);
        }
    }

    public static Set<Class<?>> getClassList(String packageName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Set<Class<?>> classes = new HashSet<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(packageName.replace('.', '/'));
            while (resources.hasMoreElements()) {
                URL resource = resources.nextElement();
                File file = new File(resource.getFile());
                if (file.isDirectory()) {
                    String[] fileList = file.list();
                    if (fileList != null) {
                        for (String fileName : fileList) {
                            classes.add(Class.forName(packageName + DOT + fileName.substring(0, fileName.lastIndexOf(DOT))));
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return classes;
    }
}