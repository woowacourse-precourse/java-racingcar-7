package racingcar.controller;

import racingcar.validator.Validator;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    public List<String> parseCarNames() {
        String input = InputView.getCarNames();
        List<String> carNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        // 자동차 이름 유효성 검사
        Validator.validateNameLength(carNames);
        Validator.validateNameFormat(carNames);
        Validator.validateUniqueNames(carNames);

        return carNames;
    }

    public int getAttemptCount() {
        int attemptCount = InputView.getAttemptCount();
        Validator.validateAttemptCount(attemptCount);
        return attemptCount;
    }
}
