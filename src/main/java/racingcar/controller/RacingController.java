package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.model.Race;

public class RacingController {
    private final InputHandler inputHandler;
    public RacingController(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }
    public void run() {
        List<String> racingCarsName = inputHandler.getCarInput();
        Integer iterationInput = inputHandler.getIterationInput();

        Race race = new Race(racingCarsName);

        int iteration=0;
        while (iteration < iterationInput) {
            HashMap<String, Integer> raceResults = race.retrieveRaceResults();
            iteration++;
        }
    }
}
