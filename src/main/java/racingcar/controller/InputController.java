package racingcar.controller;

import racingcar.view.InputView;
import racingcar.util.validator.CarNameValidator;
import racingcar.util.validator.TrialsCountValidator;
import racingcar.util.Util;
import java.util.Arrays;
import java.util.List;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public List<String> readCarNames() {
        String input = inputView.readCarNames();
        new CarNameValidator().validate(input);
        return Arrays.asList(Util.removeSpace(input).split(","));
    }

    public int readTrialsCount() {
        String input = inputView.readTrialsCount();
        new TrialsCountValidator().validate(input);
        return Integer.parseInt(Util.removeSpace(input));
    }
}