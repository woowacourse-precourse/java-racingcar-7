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
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
