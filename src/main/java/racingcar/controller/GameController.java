package racingcar.controller;

import java.util.List;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.service.GameService;
import racingcar.util.Parser;
import racingcar.util.Validator;
import racingcar.view.InputView;

public class GameController {
    private final GameService gameService;
    private final InputView inputView;

    public GameController() {
        this.gameService = new GameService();
        this.inputView = new InputView();
    }

    public void run() {
        Cars cars = gameService.createCars(inputView.carNamesInput());
        Integer gameRound = gameService.getGameRoundInput(inputView.gameRoundInput());
        Game game = new Game(cars, gameRound);

        gameService.playGame(game);
    }

}
