package racingcar.config;

import racingcar.controller.GameController;
import racingcar.domain.GameBoard;
import racingcar.domain.RaceJudge;
import racingcar.service.GameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

//Application -> GameController -> (View, GameService -> GameBoard, RaceJudge)
public class ObjectFactory {
    public static GameController createGameController() {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        GameBoard gameBoard = new GameBoard();
        RaceJudge raceJudge = new RaceJudge();

        GameService gameService = new GameService(gameBoard, raceJudge);

        return new GameController(inputView, outputView, gameService);
    }
}