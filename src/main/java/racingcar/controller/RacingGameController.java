package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.model.RacingCars;
import racingcar.validation.Validator;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameView view;
    private final Validator carNamesValidator;
    private final Validator attemptCountValidator;

    public RacingGameController(
        RacingGameView view,
        Validator carNamesValidator,
        Validator attemptCountValidator
    ) {
        this.view = view;
        this.carNamesValidator = carNamesValidator;
        this.attemptCountValidator = attemptCountValidator;
    }

    public void play() {
        List<String> racingCarNames = getRacingCarNames();

        Long attemptCount = getAttemptCount();
    }

    private List<String> getRacingCarNames() {
        view.printCarNamesInputMessage();
        String carNames = view.getInput();

        carNamesValidator.validate(carNames);

        return Arrays.asList(carNames.split(","));
    }

    private Long getAttemptCount() {
        view.printAttemptCountInputMessage();
        String attemptCount = view.getInput();

        attemptCountValidator.validate(attemptCount);

        return Long.valueOf(attemptCount);
    }
}
