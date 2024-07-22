package module;

import java.util.*;

public class RandomModule {
    private final static Random RANDOM = new Random();

    public static int getNumber(int count) {
        return RANDOM.nextInt(count);
    }

    public static int[] getArray(int count) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        while (set.size() < count) {
            int number = getNumber(count);
            if (!set.contains(number)) {
                list.add(number);
                set.add(number);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
