package racingcar.domain;

import java.util.List;

public class CarService {
    private static final int CAR_MOVE_CONDITION = 4;

    public void progressGame(List<Car> cars) {
        for (Car car : cars) {
            if (RandomNumber.getRandomNumber() >= CAR_MOVE_CONDITION) {
                car.move();
            }
        }
    }

}
