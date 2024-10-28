package racingcar.controller;

import racingcar.model.Cars;
import racingcar.model.ExecutionNumber;
import racingcar.service.RaceService;
import racingcar.service.RegisterCarService;
import racingcar.service.RegisterExecutionNumberService;
import racingcar.service.GameService;

import java.util.List;


public class GameController {

    private final GameService gameService;
    private final RegisterCarService registerCarService;
    private final RegisterExecutionNumberService registerExecutionNumberService;
    private final RaceService raceService;

    public GameController(final GameService gameService,
                          final RegisterCarService registerCarService,
                          final RegisterExecutionNumberService registerExecutionNumberService,
                          final RaceService raceService) {
        this.gameService = gameService;
        this.registerCarService = registerCarService;
        this.registerExecutionNumberService = registerExecutionNumberService;
        this.raceService = raceService;
    }

    public Cars registerCars(final String input) {
        return registerCarService.registerCars(input);
    }

    public ExecutionNumber registerExecutionNumber(final String executionNumberInput) {
        return registerExecutionNumberService.registerExecutionNumber(executionNumberInput);
    }

    public Cars race(Cars racingCars) {
        return raceService.race(racingCars);
    }

    public List<String> raceResult(Cars cars) {
        return gameService.winners(cars);
    }
}
