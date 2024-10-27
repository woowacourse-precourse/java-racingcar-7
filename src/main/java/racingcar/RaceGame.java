package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RaceGame {
    private final List<Car> cars;
    private final int rounds;

    public RaceGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            playRound();
            System.out.println();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0 ,9);
            if (car.canMove(randomValue)) {
                car.moveForward();
            }
            printCarPosition(car);
        }
    }

    private void printCarPosition(Car car) {
        System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자: " + String.join(", ", winners));
    }
}
