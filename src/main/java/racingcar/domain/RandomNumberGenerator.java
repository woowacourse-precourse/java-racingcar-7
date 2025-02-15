package racingcar.domain;

import java.util.Random;

public class RandomNumberGenerator {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private static final Random RANDOM = new Random();

    public static int generate() {
        return RANDOM.nextInt((MAX - MIN) + 1) + MIN;
    }
}
