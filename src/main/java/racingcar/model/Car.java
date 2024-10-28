package racingcar.model;

import racingcar.util.RandomNumberGenerator;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        this.position = 0;
    }

    public void go() {
        if (RandomNumberGenerator.generateSingleNumberBetweenZeroAndNine() >= 4) {
            position++;
        }
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }
}
