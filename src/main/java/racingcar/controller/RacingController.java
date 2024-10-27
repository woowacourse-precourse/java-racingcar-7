package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class RacingController {
    public void startRace() {
        List<String> cars = InputView.carNameInput();
        int moveCount = InputView.moveCountInput();
    }
}
