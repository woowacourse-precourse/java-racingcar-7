package racingcar.controller;

import java.util.List;
import racingcar.dto.RacingCarInput;
import racingcar.io.InputManager;
import racingcar.io.OutputManager;
import racingcar.model.race.Race;

public class RacingCarController {
    public RacingCarController() {
    }

    public void runRacingCar() {
        InputManager inputManager = InputManager.getInstance();
        RacingCarInput racingCarInput = inputManager.createRacingCarInput();
        Race race = new Race(racingCarInput);
        String executionResult = race.raceRun();
        OutputManager.printExecutionResult(executionResult);
        List<String> winnersList = race.getWinners();
        OutputManager.printWinnerResult(winnersList);
    }
}
