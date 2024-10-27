package racingcar.controller;

import java.io.IOException;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService = new GameService();

    public void startGame() throws IOException {
        GameData gameData = gameService.getGameData();
        gameService.playGame(gameData);

        List<Car> winnerCars = gameData.getWinnerCars();
        gameService.announceWinners(winnerCars);
    }

}
