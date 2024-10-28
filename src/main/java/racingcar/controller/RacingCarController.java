package racingcar.controller;

import java.util.List;
import racingcar.controller.validator.Validator;
import racingcar.controller.validator.ValidatorFactory;
import racingcar.model.Racing;
import racingcar.view.RacingCarView;

public class RacingCarController {
    private final ValidatorFactory validatorFactory;
    private final RacingCarView racingCarView;
    private Racing racing;
    private Integer round;

    public RacingCarController(RacingCarView racingCarView, ValidatorFactory validatorFactory) {
        this.validatorFactory = validatorFactory;
        this.racingCarView = racingCarView;
        withRacing(racingCarView.inputCarNames());
        withRound(racingCarView.inputRound());
    }

    private void withRacing(String input) {
        Validator<List<String>> carValidator = validatorFactory.getCarValidator();
        List<String> carNames = carValidator.validate(input);
        this.racing = new Racing(carNames);
    }

    private void withRound(String input) {
        Validator<Integer> roundValidator = validatorFactory.getRoundValidator();
        this.round = roundValidator.validate(input);
    }
}
