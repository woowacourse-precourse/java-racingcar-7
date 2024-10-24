package racingcar.controller;

import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController() {
        inputView = new InputView();
    }

    public void start() {
        String carNames = inputView.requestCarNames();
        String round = inputView.requestRaceRound();
    }
}
