package racingcar.controller;

import racingcar.service.GameService;
import racingcar.service.RaceService;
import racingcar.service.RegisterCarService;
import racingcar.service.RegisterExecutionNumberService;
import racingcar.util.DataTransformUtil;
import racingcar.util.ValidationUtil;

public class GameControllerFactory {

    public static GameController createGameController() {
        ValidationUtil validationUtil = new ValidationUtil();
        DataTransformUtil dataTransformUtil = new DataTransformUtil();

        GameService gameService = new GameService();
        RegisterCarService registerCarService = new RegisterCarService(validationUtil, dataTransformUtil);
        RegisterExecutionNumberService registerExecutionNumberService = new RegisterExecutionNumberService(validationUtil, dataTransformUtil);
        RaceService raceService = new RaceService(gameService);

        return new GameController(gameService, registerCarService, registerExecutionNumberService, raceService);
    }
}
