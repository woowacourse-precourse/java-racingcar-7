package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class RacingGame {
    private final List<Car> cars;
    private final int rounds;

    public RacingGame(String inputNames, int rounds) {
        this.cars = parseCars(inputNames);
        this.rounds = rounds;
    }

    private List<Car> parseCars(String input) {
        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

    public void play() {
        for (int i = 0; i < rounds; i++) {
            playRound();
            printRoundResult();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.move();
            }
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPosition());
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
