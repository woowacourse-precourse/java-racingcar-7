package racingcar.controller;

import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void executeRace(int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            gameService.moveCarsRandomly();
        }
    }


}
