import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ClassExplorer {
    private static final String BLANK = "";
    private static final String DOT = ".";

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
