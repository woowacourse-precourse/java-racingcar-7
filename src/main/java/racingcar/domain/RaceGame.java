package racingcar.domain;

import racingcar.utils.OutputHandler;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {
    private final List<Car> cars;
    private final int attemptCount;

    public RaceGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
    }

    public void startRace() {
        OutputHandler outputHandler = new OutputHandler();

        for (int i = 0; i < attemptCount; i++) {
            playRound();
            outputHandler.printRoundResults(cars);
        }

        List<Car> winners = determineWinner();
        outputHandler.printWinners(winners);
    }

    public void playRound() {
        for (Car car : cars) {
            car.moveForward();
        }
    }

    public List<Car> determineWinner() {
        int maxPosition = cars.stream()
                .max(Comparator.comparingInt(Car::getPosition))
                .orElseThrow()
                .getPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
