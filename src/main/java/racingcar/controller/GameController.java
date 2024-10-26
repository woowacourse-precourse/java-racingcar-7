package racingcar.controller;

import racingcar.model.Car;
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

    public List<Car> registerCars(final String input) {
        return registerCarService.registerCars(input);
    }

    public int registerExecutionNumber(final String executionNumberInput) {
        return registerExecutionNumberService.registerExecutionNumber(executionNumberInput);
    }

    public void race(Car racingCar) {
        raceService.race(racingCar);
    }

    public List<Car> raceResult(List<Car> cars) {
        return gameService.winners(cars);
    }
}
