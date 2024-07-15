package sort;

import java.util.Random;

public class RandomModule {
    private final static Random RANDOM = new Random();

    public static int getNumber(int count) {
        return RANDOM.nextInt(count);
    }
}
