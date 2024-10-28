package racingcar;

import java.io.IOException;
import racingcar.controller.GameController;
import racingcar.service.CarService;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) throws IOException {
        CarService carService = new CarService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameService gameService = new GameService(carService, inputView, outputView);

        GameController gameController = new GameController(gameService);
        gameController.startGame();
    }
}
