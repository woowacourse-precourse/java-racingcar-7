package racingcar.model;

import racingcar.exceptions.ValidateError;

public class Car {
    private final String carName;
    private int score;

    public Car(String carName) {
        ValidateError.validateCarName(carName);
        this.carName = carName;
    }

    public String getCarName() {
        return carName;
    }

    public int getScore() {
        return score;
    }
}
