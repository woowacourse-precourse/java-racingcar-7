package racingcar.model;

import racingcar.validator.RaceValidator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames, int numberOfRounds) {
        RaceValidator.validateRounds(numberOfRounds); // 시도 횟수 검증
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
