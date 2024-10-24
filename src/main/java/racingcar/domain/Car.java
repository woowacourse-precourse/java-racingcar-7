package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int MOVING_STANDARD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(RandomNumberGenerator randomNumberGenerator) {
        int randomNum = randomNumberGenerator.getRandomNumber();
        if (randomNum >= MOVING_STANDARD) {
            position++;
        }
    }
}
