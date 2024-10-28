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

        }
    }

    private void generateRandomValuesForCars() {
        for (Car car : cars) {
            int randomValue = RandomNumberGenerator.generateRandomNumber();
        }
    }
}
