package racingcar.model.domain;

import racingcar.model.NumberGenerator;
import racingcar.model.RandomNumberGenerator;

import java.util.List;

public class Cars {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    private Cars(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public static Cars from(List<String> names) {
        List<Car> cars = names.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars, new RandomNumberGenerator());
    }

    // 테스트를 위한 메서드
    public static Cars from(List<String> names, NumberGenerator numberGenerator) {
        List<Car> cars = names.stream()
                .map(Car::from)
                .toList();

        return new Cars(cars, numberGenerator);
    }

    public List<String> getNames() {
        return cars.stream()
                .map(Car::getName)
                .toList();
    }

    public Cars moveForward() {
        List<Car> movedCars = cars.stream()
                .map(car -> car.moveForward(numberGenerator.generate()))
                .toList();
        return new Cars(movedCars, this.numberGenerator);
    }

    public List<Integer> getPositions() {
        return cars.stream()
                .map(Car::getPosition)
                .toList();
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
