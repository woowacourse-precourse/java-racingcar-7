package racingcar.component;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.CustomConsole;

public class Game {
    private final int round;
    private final List<Car> cars;
    private final List<Car> winners;

    protected Game(int round, List<Car> cars) {
        this.round = round;
        this.cars = cars;
        this.winners = new ArrayList<>();
    }

    public static Game create() {
        System.out.print("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)\n자동차 이름: ");
        List<Car> cars = Car.makeListFrom(CustomConsole.readLine());

        System.out.println("시도할 회수는 몇 회인가요?");
        int round = Integer.parseInt(CustomConsole.readLine());

        return new Game(round, cars);
    }

    public void start() {
        System.out.println("실행 결과");

        for (int i = 0; i < round; i++) {
            processRound();
            printRound();
        }

        calculateWinners();
        printWinners();
    }

    private void processRound() {
        cars.forEach(Car::moveOrNot);
    }

    private void printRound() {
        cars.forEach(Car::printPosition);
        System.out.println();
    }

    private void calculateWinners() {
        int maxPosition = findMaxPosition();
        cars.stream()
                .filter(car -> car.checkWinner(maxPosition))
                .forEach(winners::add);
    }

    private int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    private void printWinners() {
        String names = String.join(", ", winners.stream()
                .map(Car::getName)
                .toList());

        System.out.print("최종 우승자 : " + names);
    }
}
