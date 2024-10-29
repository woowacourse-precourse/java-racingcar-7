package racingcar.controller;

import racingcar.model.service.GameService;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.domain.GameResult;
import racingcar.validator.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    public void runGame() throws IllegalArgumentException {

        String carNamesInput = InputView.inputNames();
        List<String> carNames = Arrays.asList(carNamesInput.split("\\s*,\\s*"));

        int attemptCount = InputView.inputGameCnt();
        Validator.validateAttemptCount(String.valueOf(attemptCount));

        Validator.validateCarNames(carNames);

        GameService gameService = new GameService(carNames, attemptCount, new RandomNumberGenerator());
        GameResult gameResult = gameService.playGame();

        OutputView.printResult(gameResult.getRoundResults());

        OutputView.printWinner(gameResult.getWinners());
    }
}
