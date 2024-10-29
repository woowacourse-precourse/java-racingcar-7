package racingcar.model;

import racingcar.util.RandomNumber;

public class Car {
    private final String name;
    private int forward = 0;

    public Car(String carName) {
        this.name = carName;
    }

    public void moveForward() {
        if (RandomNumber.getRandomNumber() >= 4) {
            forward = forward + 1;
        }
    }

    public String getResult() {
        StringBuilder result = new StringBuilder(name + " : ");
        result.append("-".repeat(Math.max(0, forward)));
        return String.valueOf(result);
    }

    public String getName() {
        return name;
    }

    public int getForward() {
        return forward;
    }

}
