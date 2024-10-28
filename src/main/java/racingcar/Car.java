package racingcar;

import racingcar.util.RandomNumberGenerator;

public class Car {

    private static final int STANDARD_NUMBER = 4;

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (RandomNumberGenerator.generateRandomNumber() > STANDARD_NUMBER) {
            distance++;
        }
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}
