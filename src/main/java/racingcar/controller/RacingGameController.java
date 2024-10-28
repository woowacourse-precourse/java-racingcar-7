package racingcar.controller;

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
        return carNames;
    }
}
