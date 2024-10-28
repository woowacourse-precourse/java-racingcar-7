package racingcar.controller;

import racingcar.controller.handler.ConsoleInputHandler;
import racingcar.controller.handler.ConsoleOutputHandler;
import racingcar.dto.RaceRequestDTO;
import racingcar.dto.RaceResultDTO;
import racingcar.service.RacingService;

public class RacingController {

    private final RacingService racingService;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleOutputHandler outputHandler;

    public RacingController(RacingService racingService, ConsoleInputHandler inputHandler,
                            ConsoleOutputHandler outputHandler) {
        this.racingService = racingService;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void executeRace() {
        RaceRequestDTO raceRequest = inputHandler.getRaceRequest();
        RaceResultDTO raceResult = racingService.runAllRaces(raceRequest);
        outputHandler.displayResults(raceResult.getRaceResult());
    }
}
