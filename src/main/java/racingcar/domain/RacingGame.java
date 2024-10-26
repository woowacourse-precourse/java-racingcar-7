package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.util.RandomGenerator;

public class RacingGame {

    private final CarContainer carContainer;
    private final RandomGenerator randomGenerator;

    public RacingGame(String invalidCarNames, RandomGenerator randomGenerator) {
        CarsParser CarsParser = new CarsParser();

        this.carContainer = new CarContainer(CarsParser.parse(invalidCarNames));
        this.randomGenerator = randomGenerator;
    }

    public String proceedRound() {
        carContainer.moveAll(randomGenerator);

        return String.join("", carContainer.getCurrentRoundResult());
    }

    public String findWinnerCarNames() {
        List<Car> cars = carContainer.getCars();
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
