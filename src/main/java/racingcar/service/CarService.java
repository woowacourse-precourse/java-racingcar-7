package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarService {

    public List<Car> validateCarNames(final String carNames) {
        List<Car> cars = new ArrayList<>();
        List<String> carNamesSet = new ArrayList<>();

        for (final String carName : carNames.split(",")) {
            if (carName.length() > 5){
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            if (carNamesSet.contains(carName)) {
                throw new IllegalArgumentException("중복된 자동차 이름을 입력했습니다.");
            }

            if (carName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 공백일 수 없습니다.");
            }

            carNamesSet.add(carName);
            cars.add(new Car(carName, 0));
        }

        return cars;
    }
}
