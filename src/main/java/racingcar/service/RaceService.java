package racingcar.service;

import racingcar.model.Cars;

public class RaceService {

    private final GameService gameService;

    public RaceService(GameService gameService) {
        this.gameService = gameService;
    }

    public Cars race(Cars racingCars) {
        return racingCars.moveOneTurn(gameService);
    }
}
