package racingcar.controller;

import racingcar.converter.Converter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    private final Converter<String, Integer> converter;

    public RacingController(Converter<String, Integer> converter) {
        this.converter = converter;
    }

    public void startGame() {
        String carNames = getCarNames();
        int tryCount = getTryCount();
    }

    private static String getCarNames() {
        OutputView.showCarNameInputMessage();
        return InputView.inputCarNames();
    }

    private int getTryCount() {
        OutputView.showTryCountInputMessage();
        String input = InputView.inputTryCount();
        return converter.convert(input);
    }
}
