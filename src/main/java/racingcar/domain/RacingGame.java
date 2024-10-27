package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomDigitGenerator;
import racingcar.util.RandomGenerator;

public class RacingGame {

    private final RandomGenerator randomGenerator;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        randomGenerator = new RandomDigitGenerator();
        this.cars = cars;
    }

    public void proceedRound() {
        cars.forEach(car -> car.moveForward(randomGenerator));
    }

    public String getCurrentRoundResult() {
        List<String> currentCarResult = cars.stream()
            .map(Car::toString)
            .toList();

        return String.join("", currentCarResult);
    }

    public String findWinnerCarNames() {
        int maxPosition = findMaxPosition();

        return cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }

    private int findMaxPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElse(Integer.MIN_VALUE);
    }
}
