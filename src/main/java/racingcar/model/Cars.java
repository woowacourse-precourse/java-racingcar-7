package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(RandomNumGenerator.generateRandomNumber());
        }
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow(() -> new IllegalArgumentException("최대 위치를 찾을 수 없습니다."));
    }
}
