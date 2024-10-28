package racingcar.controller;

import racingcar.model.CarNamesParser;
import racingcar.model.Input;
import racingcar.validator.CarVaildator;
import racingcar.validator.TryVaildator;
import racingcar.view.InputView;

public class InputController {
    private final InputView inputView;

    public InputController(InputView inputView) {
        this.inputView = inputView;
    }

    public Input getInput() {
        String carNames = inputView.getCar();
        CarNamesParser carNameParser = new CarNamesParser(carNames);

        String tryCount = inputView.getTryCount();

        return new Input(carNameParser.getCarNames(), Integer.parseInt(tryCount));
    }
}
