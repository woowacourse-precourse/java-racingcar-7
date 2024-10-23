package racingcar.service;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class CarService {
    private static final int BASE_DISTANCE = 0;

    private final Set<Car> cars = new LinkedHashSet<>();

    public void addCar(String carName, int distance) {
        Car car = new Car(carName, distance);
        if (!cars.add(car)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름을 추가할 수 없습니다.");
        }
    }

    public List<Car> moveAllCars() {
        cars.forEach(Car::move);
        return cars.stream().toList();
    }

    public List<String> getCarsWithMaxDistance() {
        int maxDistance = calculateMaxDistance();
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int calculateMaxDistance() {
        return cars.stream().mapToInt(Car::getDistance).max().orElse(BASE_DISTANCE);
    }

}