package racingcar.controller;

import racingcar.domain.GameData;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        GameData gameData = gameService.initializeGame();
        gameService.startGame(gameData);
        gameService.announceWinners(gameData);
    }
}
