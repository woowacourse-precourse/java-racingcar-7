package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.model.Car;

public class RacingCarService {

    public List<Car> initializeCars(List<String> carNameList) {
        return carNameList.stream()
                .map(Car::new)
                .toList();
    }

    public void moveCars(List<Car> carList) {
        carList.forEach(this::tryToMoveCar);
    }

    private void tryToMoveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.move();
        }
    }

                .toList();
    }
}
