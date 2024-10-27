package racingcar.controller;

import java.util.List;
import racingcar.model.RacingGame;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {
    public void run() {
        RacingConfig racingConfig = getUserInput();
        RacingGame racingGame = executeRacing(racingConfig);
        printResult(racingGame);
    }

    private RacingConfig getUserInput() {
        OutputView.printInsertCarsName();
        String rawUserInput = InputView.getInputCarsName();
        OutputView.printInsertTryCount();
        String rawTryCount = InputView.getInputTryNumber();

        return new RacingConfig(rawUserInput, rawTryCount);
    }

    private RacingGame executeRacing(RacingConfig racingConfig) {
        RacingGame racingGame = racingConfig.readyRacingGame();
        racingGame.runAllCycle();

        return racingGame;
    }

    private void printResult(RacingGame racingGame) {
        String racingResult = racingGame.getRacingResult();

        OutputView.printGameResultMessage();
        OutputView.printRacingResult(racingResult);
        List<String> FinalWinners = racingGame.getFinalWinner();

        OutputView.printFinalWinner(FinalWinners);
    }
}
