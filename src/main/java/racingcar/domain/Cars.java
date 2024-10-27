package racingcar.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(String carNamesInput) {
        validateNotBlank(carNamesInput);
        List<String> carNames = parseCarNames(carNamesInput);
        validateNoDuplicates(carNames);
        this.cars = createCars(carNames);
    }

    public void attemptCarMovements(MoveStrategy moveStrategy) {
        cars.forEach(car -> car.move(moveStrategy));
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    public List<Car> get() {
        return Collections.unmodifiableList(cars);
    }

    private void validateNotBlank(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException("자동차 이름 목록이 비어 있지 않아야 합니다.");
        }
    }

    private void validateNoDuplicates(List<String> carNames) {
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 자동차 이름이 있습니다.");
        }
    }

    private List<String> parseCarNames(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(","))
                .map(String::trim)
                .toList();
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}