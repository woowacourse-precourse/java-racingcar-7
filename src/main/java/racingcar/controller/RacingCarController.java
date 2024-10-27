package racingcar.controller;

import racingcar.view.RacingCarView;

public class RacingCarController {

    RacingCarView view = new RacingCarView();

    public void startGame() {
        view.printInputGuide();
    }
}
