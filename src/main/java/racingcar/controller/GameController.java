package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    private static GameController instance = new GameController();
    public static GameController getInstance() {
        return instance;
    }

    private GameService gameService = GameService.getInstance();

    public void game(String cars, int turn) {
        gameService.game(cars, turn);
    }
}
