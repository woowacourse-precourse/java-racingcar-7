package racingcar.entity;

import static racingcar.config.GameConstant.MOVEMENT_THRESHOLD;

public class Car {
    private String carName;
    private int position;

    public Car(String carName) {
        this.carName = carName;
        position = 0;
    }

    public String getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    public void moveCar(int randomNumber) {
        if (randomNumber >= MOVEMENT_THRESHOLD) {
            position++;
        }
    }
}
