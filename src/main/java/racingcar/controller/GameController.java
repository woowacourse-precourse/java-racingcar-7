package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void startGame() {
        gameService.getCarNames();
        gameService.getRounds();
    }
}
