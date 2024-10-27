package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingcarController {
    private List<Car> cars = new ArrayList<>();
    private static final int MOVE_THRESHOLD = 4;

    public void playGame() {
        String carNames = inputCarNames();
        cars = Car.createCarsFromNames(carNames);
        int attemptCount = inputAttemptCount();

        for (int i = 0; i < attemptCount; i++) {
            raceCars();
            displayCurrentPositions();
        }
        announceWinners();
    }

    private String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int inputAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        return validateAttemptCount(input);
    }

    private int validateAttemptCount(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    private void raceCars() {
        for (Car car : cars) {
            if (shouldMoveForward()) {
                car.moveForward();
            }
        }
    }

    private boolean shouldMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD;
    }

    private void displayCurrentPositions() {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.print(car.getName() + " : " + "-".repeat(car.getPosition()) + "\n");
        }
        System.out.println();
    }

    private void announceWinners() {
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