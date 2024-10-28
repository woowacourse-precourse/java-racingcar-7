package racingcar.controller;

import racingcar.RandomNumberGenerator;
import racingcar.model.Car;
import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {
    private List<Car> cars;

    public List<String> parseCarNames() {
        String input = InputView.getCarNames();
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 자동차 이름 유효성 검사
        Validator.validateNameLength(carNames);
        Validator.validateNameFormat(carNames);
        Validator.validateUniqueNames(carNames);

        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        return carNames;
    }

    public int getAttemptCount() {
        int attemptCount = InputView.getAttemptCount();
        Validator.validateAttemptCount(attemptCount);
        return attemptCount;
    }

    // 입력된 시도 횟수만큼 레이스를 반복
    public void startRace(int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            raceCars();
            printRaceStatus();
            System.out.println();
        }
        printWinner();
    }

    private void raceCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRaceStatus() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private List<Car> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private void printWinner() {
        List<Car> winners = getWinners();
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
