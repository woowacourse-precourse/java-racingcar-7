package racingcar.controller;

import java.util.Arrays;
import java.util.List;

import racingcar.validation.Validator;
import racingcar.view.RacingGameView;

public class RacingGameController {

    private final RacingGameView view;
    private final Validator carNamesValidator;

    public RacingGameController(
        RacingGameView view,
        Validator carNamesValidator
    ) {
        this.view = view;
        this.carNamesValidator = carNamesValidator;
    }

    public void play() {
        view.printCarNamesInputMessage();
        String carNames = view.getInput();

        List<String> names = getNames(carNames);
    }

    private List<String> getNames(String carNames) {
        carNamesValidator.validate(carNames);

        return Arrays.asList(carNames.split(","));
    }
}
