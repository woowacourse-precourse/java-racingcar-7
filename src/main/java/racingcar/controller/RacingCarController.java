package racingcar.controller;

import java.util.List;
import racingcar.domain.GameRoundHistory;
import racingcar.domain.RacingCarGame;
import racingcar.domain.SeparateCarNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void run() {
        String inputCarNames = InputView.enterCarNames();
        String inputNumber = InputView.enterNumberOfAttempts();

        List<String> carNames = SeparateCarNames.separateCarNames(inputCarNames);

        RacingCarGame racingCarGame = new RacingCarGame(carNames);

        OutputView.attemptsResult();

        OutputView.eachAttemptsResult(racingCarGame.playCarGame(Integer.parseInt(inputNumber)));
        OutputView.finalWinners();
        OutputView.finalWinnersResult(GameRoundHistory.getFinalResult());
    }
}
