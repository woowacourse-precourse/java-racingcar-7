package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.service.RacingGameService;
import racingcar.validator.InputValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final RacingGameService racingGameService;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.inputValidator = new InputValidator();
        this.racingGameService = new RacingGameService();
    }

    public void start() {
        String carNames = getValidatedCarNames();
        int attempts = getValidatedAttempts();

        outputView.printResultStart();
        Cars gameResult = racingGameService.play(carNames, attempts);
        outputView.printRoundResult(gameResult.getCars());
        outputView.printWinners(gameResult.findWinners());
    }

    private String getValidatedCarNames() {
        String input = inputView.readCarNames();
        inputValidator.validateCarNames(input);
        return input;
    }

    private int getValidatedAttempts() {
        String input = inputView.readAttempts();
        inputValidator.validateAttempts(input);
        return Integer.parseInt(input);
    }
}
