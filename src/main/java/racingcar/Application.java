package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start();
    }
}

class RacingGame {
    private List<Car> cars;
    private int attemptCount;

    public void start() {
        cars = getCars();
        attemptCount = getAttemptCount();
    }

    private List<Car> getCars() {
        System.out.println("경주할 자동차 이름 입력 (이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }

    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.trim().length() > 5 || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
            }
        }
    }

    private int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private void runGame() {
        for (int i = 0; i < attemptCount; i++) {
            playRound();
            printRoundResults();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}

class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            position++;
        }
    }
}