package racingcar.controller;

import racingcar.service.validation.InputValidator;
import racingcar.model.Car;
import racingcar.model.InputParser;
import racingcar.service.RacingService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputParser inputParser;
    private final InputValidator<List<String>> nameValidator;
    private final InputValidator<String> attemptNumberValidator;
    private final RacingService racingService;

    public RacingController(InputParser inputParser, InputValidator<List<String>> nameValidator, InputValidator<String> attemptNumberValidator, RacingService racingService) {
        this.inputParser = inputParser;
        this.nameValidator = nameValidator;
        this.attemptNumberValidator = attemptNumberValidator;
        this.racingService = racingService;
    }

    public void run() {
        List<String> names = getNames();
        String attempt = getAttempt();
        race(names, attempt);
        pickWinners();
    }

    private List<String> getNames() {
        OutputView.printCarNames();
        String initialNames = InputView.enter();
        List<String> names = inputParser.parseName(initialNames);
        nameValidator.validate(names);

        return names;
    }

    private String getAttempt() {
        OutputView.printAttemptCount();
        String initialAttempt = InputView.enter();
        attemptNumberValidator.validate(initialAttempt);

        return initialAttempt;
    }

    private void race(List<String> names, String attempt) {
        OutputView.printResultMessage();
        racingService.operate(names, attempt);
    }

    private void pickWinners() {
        List<Car> winners = racingService.getWinner();
        OutputView.printWinner(winners);
    }
}