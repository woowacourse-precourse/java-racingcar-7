package racingcar.controller;

import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.model.attemptcountinput.AttemptCountValidation;
import racingcar.model.carnameinput.CarNameSplit;
import racingcar.model.carnameinput.CarNameValidation;
import racingcar.model.race.Race;

public class RacingCarController {
    public RacingCarController() {
    }

    public void runRacingCar() {
        InputManager inputManager = InputManager.getInstance();
        String carName = inputManager.carNameInput();
        String[] carNameArray = CarNameSplit.nameSplit(carName);
        CarNameValidation.carNameValidate(carNameArray);
        String attemptCount = inputManager.attemptCountInput();
        int attemptCountNumber = AttemptCountValidation.attemptCountValidation(attemptCount);
        Race race = new Race(carNameArray, attemptCountNumber);
        String executionResult = race.raceRun();
        OutputManager.printExecutionResult(executionResult);
        System.out.println(race.getWinners());
    }
}
