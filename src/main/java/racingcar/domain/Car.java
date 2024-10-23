package racingcar.domain;

import racingcar.utils.RandomNumber;

public class Car {

    private static final int MOVING_STANDARD_NUMBER = 4;

    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
    }

    public int move() {
        if (RandomNumber.generate() >= MOVING_STANDARD_NUMBER) {
            movedDistance++;
        }
        return movedDistance;
    }

}
