package racingcar.controller;

import racingcar.model.service.GameService;
import racingcar.model.RandomNumberGenerator;
import racingcar.model.domain.GameResult;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    public void runGame() {
        String carNamesInput = InputView.inputNames();
        List<String> carNames = Arrays.asList(carNamesInput.split("\\s*,\\s*"));

        int attemptCount = InputView.inputGameCnt();

        GameService gameService = new GameService(carNames, attemptCount, new RandomNumberGenerator());
        GameResult gameResult = gameService.playGame();

        gameResult.getRoundResults().forEach(OutputView::printRecord);

        OutputView.printWinner(gameResult.getWinners());
    }
}
