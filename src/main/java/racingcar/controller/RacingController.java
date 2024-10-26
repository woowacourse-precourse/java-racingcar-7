package racingcar.controller;

import static racingcar.factory.ValidatorFactory.TYPE_ATTEMPT_COUNT;
import static racingcar.factory.ValidatorFactory.TYPE_CAR_NAMES;
import static racingcar.factory.ViewFactory.TYPE_INPUT;
import static racingcar.factory.ViewFactory.TYPE_OUTPUT;
import static racingcar.factory.ViewFactory.TYPE_RUNTIME;

import racingcar.factory.ValidatorFactory;
import racingcar.factory.ViewFactory;
import racingcar.model.Race;
import racingcar.observer.RuntimeView;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final RuntimeView runtimeView;
    private final OutputView outputView;
    private final CarNameValidator carNameValidator;
    private final AttemptCountValidator attemptCountValidator;

    public RacingController(ViewFactory viewFactory, ValidatorFactory validatorFactory) {
        this.inputView = (InputView) viewFactory.create(TYPE_INPUT);
        this.runtimeView = (RuntimeView) viewFactory.create(TYPE_RUNTIME);
        this.outputView = (OutputView) viewFactory.create(TYPE_OUTPUT);
        this.carNameValidator = (CarNameValidator) validatorFactory.create(TYPE_CAR_NAMES);
        this.attemptCountValidator = (AttemptCountValidator) validatorFactory.create(TYPE_ATTEMPT_COUNT);
    }

    public void run() {
        String carNames = inputCarNames();
        String stringAttemptCount = inputAttemptCount();

        validateInput(carNames, stringAttemptCount);

        int attemptCount = Integer.parseInt(stringAttemptCount);
        String winnerList = startRace(carNames, attemptCount);

        showWinner(winnerList);
    }

    private String inputCarNames() {
        inputView.print();
        return inputView.inputCarNames();
    }

    private String inputAttemptCount() {
        inputView.printInputAttemptCount();
        return inputView.inputAttemptCount();
    }

    private void validateInput(String carNames, String attemptCount) {
        carNameValidator.validate(carNames);
        attemptCountValidator.validate(attemptCount);
    }

    private String startRace(String carNames, int attemptCount) {
        Race race = new Race(carNames);
        race.registerObserver(runtimeView);
        runtimeView.print();
        return race.runRace(attemptCount);
    }

    private void showWinner(String winnerList) {
        outputView.print();
        outputView.printWinner(winnerList);
    }
}
