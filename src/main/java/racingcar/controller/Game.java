package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.InputOutputHandler;
import racingcar.util.RandomMovementDecider;

public class Game {
    private final InputOutputHandler ioHandler;

    public Game(InputOutputHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public void play() {
        List<Car> cars = initializeCars();
        int round = ioHandler.getRound();

        ioHandler.printRunResult();
        for (int i = 0; i < round; i++) {
            playRound(cars);
            ioHandler.printCarsStatus(cars);
        }

        List<Car> winners = determineWinners(cars);
        ioHandler.printWinners(winners);
    }

    private List<Car> initializeCars() {
        List<String> carNames = ioHandler.getCarNames();
        return createCars(carNames);
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .toList();
    }

    private void playRound(List<Car> cars) {
        cars.forEach(this::moveCarIfDecided);
    }

    private void moveCarIfDecided(Car car) {
        if (RandomMovementDecider.decide()) {
            car.move();
        }
    }

    private List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
