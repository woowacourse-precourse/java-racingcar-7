package racingcar.service;

import racingcar.validation.InputValidator;

import java.util.Arrays;
import java.util.List;

public class RacingGameService {
    public List<String> parseCarNames(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        InputValidator.validateCarNames(carNames);
        return carNames;
    }
}
