package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.GameData;
import racingcar.service.GameService;

public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public void startGame() {
        GameData gameData = gameService.getGameData();
        gameService.playGame(gameData);

        List<Car> winnerCars = gameData.getWinnerCars();
        gameService.announceWinners(winnerCars);
    }

}
