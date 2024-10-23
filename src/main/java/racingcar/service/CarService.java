package racingcar.service;

import java.util.HashSet;
import java.util.Set;
import racingcar.domain.Car;

public class CarService {
    private static final int BASE_DISTANCE = 0;

    private final Set<Car> cars = new HashSet<>();

    public void addCar(String carName) {
        Car car = new Car(carName, BASE_DISTANCE);
        if (!cars.add(car)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 추가할 수 없습니다.");
        }
    }

    public void moveAllCarsMultipleTimes(int times) {
        for (int i = 0; i < times; i++) {
            cars.forEach(Car::move);
        }
    }
}