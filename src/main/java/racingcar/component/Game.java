package racingcar.component;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Car> cars;
    private final int round;

    public Game(List<Car> cars, int round) {
        validateRound(round);

        this.cars = cars;
        this.round = round;
    }

    private void validateRound(int round) {
        if (round <= 0 || round > 10) {
            throw new IllegalArgumentException();
        }
    }

    public void start() {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            processRound();
            printRound();
        }
    }

    private void processRound() {
        cars.forEach(car -> {
            if (car.canMove()) {
                car.move();
            }
        });
    }

    private void printRound() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    public void finish() {
        List<Car> winners = findWinners();
        printWinners(winners);
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
