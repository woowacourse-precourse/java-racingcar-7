package racingcar.controller;

import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private InputView inputView = new InputView();
    private GameService gameService = new GameService();
    private OutputView outputView = new OutputView();

    public GameController(InputView inputView, GameService gameService, OutputView outputView) {
        this.inputView = inputView;
        this.gameService = gameService;
        this.outputView = outputView;
    }
    public void run() {
        String carsString = inputView.getUserInput();
        String[] cars = carsString.split(",");

    }
}
