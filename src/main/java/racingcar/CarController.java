package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class CarController {
    public static void moveCarsByRandomValue(List<Car> cars) {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            if (randomValue >= 4) {
                car.moveForward();
            }
        }
    }
}