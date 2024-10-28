package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int trials;

    public Race(List<Car> cars, int trials) {
        this.cars = cars;
        this.trials = trials;
    }

    public void start() {
        for (int i = 0; i < trials; i++) {
            runRaceRound();
            displayRaceStatus();
        }
    }

    private void runRaceRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void displayRaceStatus() {
        ResultPrinter.printRaceStatus(cars);
    }

    public List<String> determineWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public void printWinners() {
        List<String> winners = determineWinners();
        ResultPrinter.printWinners(winners);
    }
}
