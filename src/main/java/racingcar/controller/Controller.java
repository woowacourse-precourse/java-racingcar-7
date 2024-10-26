package racingcar.controller;

import racingcar.Parser;
import racingcar.Service.GameService;
import racingcar.Validator;
import racingcar.model.Game;
import racingcar.repository.CarRepository;
import racingcar.view.OutputView;

public class Controller {
    private final GameService gameService = new GameService();
    private final Parser parser = new Parser();
    private final Validator validator = new Validator();
    private final CarRepository carRepository = new CarRepository();

    private void play(Game game) {
        OutputView.printHead();
        while (!gameService.isEnd(game)) {
            gameService.play(game);
            OutputView.printScore(game.getCars());
        }
        OutputView.printWinners(gameService.getWinners(game));
    }

}
