package racingcar.controller;

import racingcar.domain.RacingCar;
import racingcar.service.GameService;
import view.InputView;
import view.OutputView;
import view.domain.InputResult;

import java.util.List;

public class GameController {

    public final void run() throws IllegalArgumentException {
        InputView inputView = new InputView();
        InputResult input = inputView.input();

        OutputView outputView = new OutputView();
        GameService gameService = new GameService(input.getCars());
        for (int i = 0; i < input.getGameCount(); i++) {
            List<RacingCar> gamePerResult = gameService.game();
            outputView.game(gamePerResult);
        }

        List<String> winner = gameService.findWinner();
        outputView.printWinner(winner);
    }
}
