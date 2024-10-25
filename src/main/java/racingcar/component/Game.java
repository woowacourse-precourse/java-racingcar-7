package racingcar.component;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final int round;
    private final List<Car> cars;
    private final List<Car> winners;

    public static Game create(int round, List<Car> cars) {
        return new Game(round, cars);
    }

    private Game(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
        this.winners = new ArrayList<>();
    }

    public void start() {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            processRound();
            printRound();
        }

        selectWinners();
        printWinners();
    }

    private void processRound() {
        cars.forEach(Car::moveOrNot);
    }

    private void printRound() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    private void selectWinners() {
        int maxPosition = findMaxPosition();
        cars.stream()
                .filter(car -> car.checkWinner(maxPosition))
                .forEach(winners::add);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private void printWinners() {
        String names = String.join(", ", winners.stream()
                .map(Car::getName)
                .toList());

        System.out.print("최종 우승자 : " + names);
    }
}
