package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarService {

    private static final int FORWARD_CONDITION = 4;

    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            if (name.length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다");
            }
            cars.add(new Car(name));
        }
        return cars;
    }

}
