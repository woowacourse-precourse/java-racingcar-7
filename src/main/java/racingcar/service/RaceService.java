package racingcar.service;

import racingcar.model.Car;

public class RaceService {

    private GameService gameService;

    public RaceService(GameService gameService) {
        this.gameService = gameService;
    }

    public void race(Car racingCar) {
        if (gameService.isMoving()) {
            racingCar.move();
        }
    }
}
