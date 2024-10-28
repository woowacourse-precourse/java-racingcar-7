package racingcar.controller;

import java.util.List;
import racingcar.domain.RacingCarGame;
import racingcar.domain.SeparateCarNames;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final SeparateCarNames separateCarNames = new SeparateCarNames();

    public void run() {
        String inputCarNames = inputView.enterCarNames();
        String inputNumber = inputView.enterNumberOfAttempts();

        List<String> carNames = separateCarNames.separateCarNames(inputCarNames);

        RacingCarGame racingCarGame = new RacingCarGame(carNames);

        outputView.attemptsResult();
        outputView.eachAttemptsResult(racingCarGame.playCarGame(Integer.parseInt(inputNumber)));
        outputView.finalWinners();
        outputView.finalWinnersResult(racingCarGame.gameRoundHistory.getFinalResult());
    }
}
