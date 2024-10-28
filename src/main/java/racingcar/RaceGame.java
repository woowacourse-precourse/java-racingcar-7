package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {
    private final List<Car> cars;
    private final int raceCount;

    public RaceGame(List<String> carNames, int raceCount) {
        this.cars = carNames.stream()
                .map(Car::new)
                .toList();
        this.raceCount = raceCount;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < raceCount; i++) {
            moveAllCars();
            printCurrentStatus();
            System.out.println();
        }
        printWinners();
    }

    private void moveAllCars() {
        cars.forEach(Car::move);
    }

    private void printCurrentStatus() {
        cars.forEach(car -> System.out.println(car.getName() + " : " + car.getPositionString()));
    }

    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
