package racingcar.domain;

import java.util.Random;

public class Number {
    private static Random random;

    public Number() {
        random = new Random();
    }

    public int getRandomNumber() {
        return random.nextInt(10);
    }
}
