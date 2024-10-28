package racingcar.controller;

import racingcar.model.domain.GameResult;
import racingcar.model.service.GameService;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private GameController() {
    }

    public static void playRacingGame() {
        OutputView.printInputName();
        String carNames = InputView.inputNames();
        Validator.validateCarNames(carNames);

        OutputView.printInputCount();
        int gameCount = InputView.inputGameCnt();
        Validator.validateGameCount(gameCount);

        GameResult result = GameService.play(gameCount, carNames);

        OutputView.printResult(result);
    }
}