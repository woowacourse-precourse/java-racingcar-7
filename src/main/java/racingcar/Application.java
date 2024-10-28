package racingcar;

import racingcar.controller.GameController;
import racingcar.service.CarService;
import racingcar.service.GameEngine;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameEngine gameEngine = new GameEngine();
        GameService gameService = new GameService(carService, inputView, outputView, gameEngine);

        GameController gameController = new GameController(gameService);
        gameController.startGame();
    }
}
