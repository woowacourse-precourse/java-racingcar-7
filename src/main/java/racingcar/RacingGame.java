package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int FORWARD_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
            car.move();
        }
    }

    public void executeRace(int attempts) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < attempts; i++) {
            race();
            printStatus();
        }
    }

    private void printStatus() {
        for (Car car : cars) {
            System.out.printf("%s : %s%n",
                    car.getName(),
                    "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public void announceWinner() {
        String winners = findWinners().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winners);
    }

    private List<Car> findWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}