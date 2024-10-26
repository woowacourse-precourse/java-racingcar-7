package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.Racing;
import racingcar.model.TextFormatter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    private final InputView inputView;
    private final OutputView outputView;
    private final Racing racing;
    private final TextFormatter textFormatter;

    public Controller(InputView inputView, OutputView outputView, Racing racing, TextFormatter textFormatter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.racing = racing;
        this.textFormatter = textFormatter;
    }

    private Cars initializeCars() {
        String carNames = inputView.readCarNames();
        String[] carNameArr = textFormatter.splitCarNamesByComma(carNames);
        return Cars.from(carNameArr);
    }
}