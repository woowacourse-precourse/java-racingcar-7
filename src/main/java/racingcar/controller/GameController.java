package racingcar.controller;

import racingcar.model.Racing;

public class GameController {
    private Racing racing;
    private int roundNumber;

    public GameController() {
        set();
    }

    public void set() {
        racing = InputController.setRacingCars();
        roundNumber = InputController.setRoundNumber();
    }
}
