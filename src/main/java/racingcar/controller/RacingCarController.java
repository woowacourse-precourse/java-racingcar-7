// RacingCarController.java
package racingcar.controller;

import racingcar.domain.RacingGame;
import racingcar.service.RacingCarService;
import racingcar.utils.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.stream.IntStream;

public class RacingCarController {
    private final RacingCarService racingCarService;
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator carNameValidator;
    private final InputValidator numberOfTrialsValidator;
    private static final int INITIAL_ROUND = 0;

    public RacingCarController(RacingCarService racingCarService, InputView inputView, OutputView outputView, InputValidator carNameValidator, InputValidator numberOfTrialsValidator) {
        this.racingCarService = racingCarService;
        this.inputView = inputView;
        this.outputView = outputView;
        this.carNameValidator = carNameValidator;
        this.numberOfTrialsValidator = numberOfTrialsValidator;
    }

    public void run() {
        outputView.printEnterCarNamesMessage();
        String carNames = inputView.getCarNames();
        carNameValidator.validate(carNames);

        outputView.printEnterTrialsCountMessage();
        String numberOfTrialsInput = inputView.getNumberOfTrials();
        numberOfTrialsValidator.validate(numberOfTrialsInput);
        int tryCount = Integer.parseInt(numberOfTrialsInput);

        racingCarService.startRace(carNames, tryCount);

        outputView.printInitialStatus();

        RacingGame racingGame = racingCarService.getRacingGame();
        racingGame.getAllRoundResults().forEach(outputView::printRoundResults);

    }
}
