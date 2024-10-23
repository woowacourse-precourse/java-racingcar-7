package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class CarController {

    private final OutputView outputView;
    private final InputView inputView;

    public CarController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void run() {
        outputView.printStartMessage();
        ArrayList<String> carNames = inputView.readCarNames();
        outputView.printAttemptMessage();
        int attemps = inputView.readAttempts();
    }
}
