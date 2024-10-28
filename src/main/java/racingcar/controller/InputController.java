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
        CarVaildator.carVaildator(carNameParser.getCarNames()); // 자동차 이름 검증

        String tryCount = inputView.getTryCount();
        TryVaildator.tryVaildator(tryCount);    // 시도 횟수 검증

        return new Input(carNameParser.getCarNames(), Integer.parseInt(tryCount));
    }
}
