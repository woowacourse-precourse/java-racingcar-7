package racingcar.model;

import racingcar.util.GetRandomValue;

public class CarMovement {
    public void moveCars(Car[] cars) {
        for (Car car : cars) {
            int randomValue = GetRandomValue.generateRandomNumber();
            car.move(randomValue);
        }
    }
}
