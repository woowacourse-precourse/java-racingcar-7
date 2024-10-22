package racingcar.util;

import java.util.Random;

public class RandomUtil {
    private static final int MAX_NUM = 9;
    private static final Random random = new Random();

    private RandomUtil() {
        throw new IllegalArgumentException("유틸 클래스입니다.");
    }

    public static int getRandomNumber() {
        return random.nextInt(MAX_NUM + 1);
    }
}
