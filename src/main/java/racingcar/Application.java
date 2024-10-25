package racingcar;

import racingcar.controller.GameController;
import racingcar.validator.CarNameValidator;
import racingcar.validator.TrialValidator;
import racingcar.validator.Validator;

public class Application {
    public static void main(String[] args) {

        Validator<String[]> nameValidator = new CarNameValidator();
        Validator<String> trialValidator = new TrialValidator();
        GameController gameController = new GameController(nameValidator, trialValidator);
    }
}
