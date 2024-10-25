package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class RacingController {

    void run() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        List<Car> cars = List.of(car1, car2);

        int totalLaps = 2;
        for (int i = 0; i < totalLaps; i++) {
            for (Car car : cars) {
                int movementFactor = generateRandomMovementFactor();
                car.attemptMove(movementFactor);
            }
        }
    }

    private int generateRandomMovementFactor() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
