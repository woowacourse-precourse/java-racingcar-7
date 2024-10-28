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

    public void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
