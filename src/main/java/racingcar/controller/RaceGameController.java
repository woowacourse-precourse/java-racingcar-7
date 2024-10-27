package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public RaceGameController(
        final InputView inputView,
        final OutputView outputView
    ){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        String racerNames = requestInputStringRacerName();
    }

    private String requestInputStringRacerName() {
        outputView.printAskInputRacerName();
        return inputView.read();
    }
}
