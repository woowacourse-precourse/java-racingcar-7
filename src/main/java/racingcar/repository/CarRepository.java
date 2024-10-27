package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        if (isNameDuplicate(car)) {
            throw new IllegalArgumentException("이미 존재하는 이름입니다.");
        }
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }

    public List<Car> getMaxDistanceCars() {
        int maxDistance = getMaxDistance();

        return this.cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private int getMaxDistance() {
        return this.cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private boolean isNameDuplicate(Car car) {
        return cars.stream()
                .anyMatch(c -> c.getName().equals(car.getName()));
    }
}