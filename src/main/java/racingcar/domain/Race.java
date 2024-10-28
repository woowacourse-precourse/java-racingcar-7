package racingcar.domain;

import racingcar.parser.CarNamesParser;

import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private static final String NEW_LINE = "\n";

    private final List<Car> cars;
    private final Integer attemptCount;

    private Race(final String input, final Integer attemptCount) {
        this.attemptCount = attemptCount;
        this.cars = createCars(CarNamesParser.parseCarNames(input));
    }

    public static Race createRace(final String input, final Integer attemptCount) {
        return new Race(input, attemptCount);
    }

    private List<Car> createCars(final List<String> carNames) {
        return carNames.stream()
                .map(Car::createCar)
                .toList();
    }

    public String displayRacingProgress() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < attemptCount-1; i++) {
            extractPosition(result);
            result.append(NEW_LINE);
        }
        extractPosition(result);

        return result.toString();
    }

    private void extractPosition(final StringBuilder result) {
        for (Car car : cars) {
            car.move();
            result.append(car.displayPosition());
        }
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
