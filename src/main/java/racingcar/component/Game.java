package racingcar.component;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final int round;
    private final List<Car> cars;

    public static Game create(int round, List<Car> cars) {
        return new Game(round, cars);
    }

    private Game(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
    }

    public void start() {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            processRound();
            printRound();
        }

        List<Car> winners = findWinners();
        printWinners(winners);
    }

    private void processRound() {
        cars.forEach(Car::moveOrNot);
    }

    private void printRound() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    private List<Car> findWinners() {
        Car firstCar = findFirstCar();
        return cars.stream()
                .filter(car -> car.isSamePosition(firstCar))
                .toList();
    }

    private Car findFirstCar() {
        return cars.stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);
    }

    private void printWinners(List<Car> winners) {
        String names = winners.stream()
                .map(Car::toString)
                .collect(Collectors.joining(", "));

        System.out.print("최종 우승자 : " + names);
    }
}
