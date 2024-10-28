package racingcar.controller;

import racingcar.service.RacingGameService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingGameController {

    private final RacingGameService racingGameService = new RacingGameService();

    public void startGame() {
        String carNamesInput = InputView.inputCarNames();
        List<String> carNames = racingGameService.processCarNames(carNamesInput);

        int numberOfAttempts = InputView.inputNumberOfAttempts();
        racingGameService.validateNumberOfAttempts(numberOfAttempts);

        racingGameService.initGame(carNames);

        OutputView.printExecutionResult();

        for (int i = 0; i < numberOfAttempts; i++) {
            racingGameService.moveCars();
            OutputView.printCars(racingGameService.getCars());
        }

        List<String> winners = racingGameService.getWinners();
        OutputView.printWinners(winners);
    }

}