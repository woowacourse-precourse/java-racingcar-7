package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        String carInput = getCarInput();
        String countInput = getCountInput();
    }

    private String getCarInput() {
        outputView.printCarInputMessage();
        return inputView.input();
    }

    private String getCountInput() {
        outputView.printCountInputMessage();
        return inputView.input();
    }
}
