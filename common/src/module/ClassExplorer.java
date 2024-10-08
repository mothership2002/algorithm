package module;

import abs.Algorithm;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.*;

public class ClassExplorer {
    private static final String DOT = ".";

    /**
     * scanning class files from target's root path
     * @param packageName @ root path
     * @return classes metadata collection set
     */
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
                    if (!Objects.isNull(fileList)) {
                        for (String fileName : fileList) {
                            if (fileName.endsWith(".class")) {
                                classes.add(Class.forName(
                                        packageName + DOT + fileName.substring(0, fileName.lastIndexOf(DOT))));
                            }
                        }
                    }
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return classes;
    }

    /**
     * execute construct wrapper method
     * @param classList @ Collection classes metadata
     * @param count     @ User input - integerGroup length
     * @param name      @ Algorithm name // if not contain in files name, all files will be executed.
     * @return Algorithm collection
     */
    public static List<Algorithm> init(Collection<Class<?>> classList, int count, String name) {
        List<Class<?>> filteredClass = classList.stream()
                .filter(clazz -> clazz.getSimpleName().toLowerCase().contains(name.toLowerCase()))
                .toList();
        return filteredClass.isEmpty()
                ? getAlgorithmList(classList, count)
                : getAlgorithmList(filteredClass, count);
    }

    /**
     * execute construct method
     * @param classList @ Collection classes metadata
     * @param count     @ User input - integerGroup length
     * @return List of Algorithm
     */
    private static List<Algorithm> getAlgorithmList(Collection<Class<?>> classList, int count) {
        List<Algorithm> algorithms = new ArrayList<>();
        for (Class<?> clazz : classList) {
            try {
                algorithms.add((Algorithm) clazz.getDeclaredConstructor(int.class).newInstance(count));
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
        return algorithms;
    }
}
