package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private static final int FORWARD_THRESHOLD = 4;
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(String[] carNames, int attempts) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            this.cars.add(new Car(name));
        }
        this.attempts = attempts;
    }

    public void play() {
        for (int i = 0; i < attempts; i++) {
            for (Car car : cars) {
                if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
                    car.move();
                }
            }
            printCurrentState();
        }
        printWinners();
    }

    private void printCurrentState() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}

