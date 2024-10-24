package racingcar.domain;

import racingcar.convertor.RaceConvertor;

import java.util.List;

public class Race {

    private static final String NEW_LINE = "\n";

    private final List<Car> cars;
    private final Integer attemptCount;

    private Race(final String input, final Integer attemptCount) {
        this.attemptCount = attemptCount;
        this.cars = createCars(RaceConvertor.parseCarNames(input));
    }

    public static Race createRace(final String input, final Integer attemptCount) {
        return new Race(input, attemptCount);
    }

    public String displayRacingProgress() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < attemptCount; i++) {
            extractPosition(result);
            result.append(NEW_LINE);
        }
        return result.toString();
    }

    private void extractPosition(StringBuilder result) {
        for (Car car : cars) {
            car.move();
            result.append(car.displayPosition());
        }
    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::createCar)
                .toList();
    }
}
