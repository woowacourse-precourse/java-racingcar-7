package racingcar.manager;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingManager {

    private final List<Car> cars = new ArrayList<>();

    public void registerCars(String carNames) {

        String[] split = carNames.split(",");

        for (String carName : split) {

            isDuplicatedName(carName);
            cars.add(Car.of(carName));
        }
    }

    private void isDuplicatedName(String carName) {
        if (cars.stream().anyMatch(car -> car.getName().equals(carName))) {
            throw new IllegalArgumentException("자동차 이름은 중복이 안됩니다.");
        }
    }

}
