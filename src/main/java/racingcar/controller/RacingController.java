package racingcar.controller;

import java.util.HashMap;
import java.util.List;
import racingcar.model.Race;

public class RacingController {
    private final ConsoleInputHandler consoleInputHandler;
    private final ConsoleOutputHandler consoleOutputHandler;

    public RacingController(ConsoleInputHandler consoleInputHandler, ConsoleOutputHandler consoleOutputHandler) {
        this.consoleInputHandler = consoleInputHandler;
        this.consoleOutputHandler = consoleOutputHandler;
    }

    public void run() {
        List<String> racingCarsName = consoleInputHandler.getCarInput();
        Integer iterationInput = consoleInputHandler.getIterationInput();

        Race race = new Race(racingCarsName);

        int iteration = 0;
        consoleOutputHandler.displayResultMessage();

        while (iteration < iterationInput) {
            HashMap<String, Integer> raceResults = race.retrieveRaceResults();
            consoleOutputHandler.printRaceResult(raceResults);
            iteration++;
        }
        List<String> winnersName = race.findWinners();
        consoleOutputHandler.printRaceWinner(winnersName);
    }
}
