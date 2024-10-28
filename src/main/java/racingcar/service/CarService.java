package racingcar.service;

import java.util.HashSet;
import racingcar.model.Car;

public class CarService {

    public HashSet<Car> validateCarNames(final String carNames) {
        HashSet<Car> cars = new HashSet<>();
        HashSet<String> carNamesSet = new HashSet<>();

        for (final String carName : carNames.split(",")) {
            if (carName.length() >= 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            if (carNamesSet.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름을 입력했습니다.");
            }

            carNamesSet.add(carName);
            cars.add(new Car(carName, 0));
        }

        return cars;
    }
}
