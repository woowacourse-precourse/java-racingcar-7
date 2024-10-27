package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.controller.io.InputHandler;
import racingcar.controller.io.OutputHandler;
import racingcar.model.Race;

public class RacingController {
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;

    public RacingController(InputHandler inputHandler, OutputHandler outputHandler) {
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void run() {
        List<String> racingCarsName = inputHandler.getCarInput();
        Integer iterationInput = inputHandler.getIterationInput();

        Race race = new Race(racingCarsName);

        race(iterationInput, race);

        List<String> winnersName = race.findWinners();
        outputHandler.printRaceWinner(winnersName);
    }

    private void race(Integer iterationInput, Race race) {
        int iteration = 0;
        outputHandler.displayResultMessage();

        while (iteration < iterationInput) {
            HashMap<String, Integer> raceResults = race.retrieveRaceResults();
            outputHandler.printRaceResult(raceResults);
            iteration++;
        }
    }
}
