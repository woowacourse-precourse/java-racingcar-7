package racingcar.controller;

import racingcar.io.InputManager;

public class RacingCarController {

    public RacingCarController() {
    }

    public void runRacingCar() {
        InputManager inputManager = InputManager.getInstance();
        System.out.println(inputManager.carNameInput());
    }
}
