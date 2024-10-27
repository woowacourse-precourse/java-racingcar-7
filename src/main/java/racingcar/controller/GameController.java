package racingcar.controller;

import java.io.IOException;
import racingcar.domain.GameData;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();

    public void startGame() throws IOException {
        GameData gameData = gameService.getGameData();
        gameService.playGame(gameData);

    }

}
