package racingcar.controller;

import java.util.List;
import racingcar.model.Car;
import racingcar.service.GameService;

public class Controller {
    private final GameService gameService = new GameService();

    public void run() {
        List<Car> cars = gameService.readyCar();
        Long times = gameService.readyTimes();
        gameService.showGameResult(gameService.playGame(cars, times));
    }
}
