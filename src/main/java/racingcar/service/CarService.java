package racingcar.service;

import java.util.HashSet;
import racingcar.model.Car;

public class CarService {

    public HashSet<Car> validateCarNames(final String carNames) {
        HashSet<Car> cars = new HashSet<>();

        for (final String carName : carNames.split(",")) {
            if (carName.length() >= 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            Car car = new Car(carName, 0);
            if (cars.contains(car)) {
                throw new IllegalArgumentException("중복된 자동차 이름을 입력했습니다.");
            }

            cars.add(car);
        }

        return cars;
    }
}
