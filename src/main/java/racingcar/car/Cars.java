package racingcar.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.exception.InvalidNameException;

public class Cars {

    private final List<Car> cars;

    public Cars(final List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void add(Car car) {
        validate(car);
        cars.add(car);
    }

    public String calculateWinners() {
        long maxPosition = calculateMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public void move() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void validate(Car car) {
        if (isDuplicateName(car.getName())) {
            throw new InvalidNameException("이름은 중복될 수 없습니다.");
        }
    }

    private boolean isDuplicateName(String name) {
        return cars.stream()
                .anyMatch(car -> car.getName().equals(name));
    }

    private Long calculateMaxPosition() {
        return cars.stream()
                .map(Car::getPosition)
                .max(Long::compare)
                .get();
    }

    public List<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public List<Long> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }
}
