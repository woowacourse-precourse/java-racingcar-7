package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.view.OutputView.printGameStart;
import static racingcar.view.OutputView.printGameStatus;

public class Game {
    private final List<Car> cars;
    private final int attemptCount;

    public Game(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void start() {
        printGameStart();
        for (int i = 0; i < attemptCount; i++) {
            moveCars();
            printGameStatus(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
