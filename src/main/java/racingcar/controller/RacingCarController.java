package racingcar.controller;

import racingcar.io.InputManager;
import racingcar.model.CarNameSplit;

public class RacingCarController {
    public RacingCarController() {
    }

    public void runRacingCar() {
        InputManager inputManager = InputManager.getInstance();
        String carName = inputManager.carNameInput();
        String[] carNameArray = CarNameSplit.nameSplit(carName);
    }
}
