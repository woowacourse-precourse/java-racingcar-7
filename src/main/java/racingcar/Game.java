package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private static final int MIN_RANDOM = 0;
    private static final int MAX_RANDOM = 9;

    private final List<Car> cars;
    private final int attemptCount;

    public Game(List<Car> cars, int attemptCount) {
        this.cars = new ArrayList<>(cars);
        this.attemptCount = attemptCount;
    }

    public void start() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attemptCount; i++) {
            playRound();
            printRoundResult();
            System.out.println();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            int number = Randoms.pickNumberInRange(MIN_RANDOM, MAX_RANDOM);
            car.move(number);
        }
    }

    private void printRoundResult() {
        cars.forEach(car -> System.out.println(car.toString()));
    }

    private void printWinners() {
        List<Car> winners = getWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println("최종 우승자 : " + winnerNames);
    }

    List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
