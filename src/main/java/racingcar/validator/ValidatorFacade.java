package racingcar.validator;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;
import racingcar.validator.exception.InvalidCarNameException;
import racingcar.validator.exception.InvalidRoundException;

public class ValidatorFacade {
    private final Validator<String> carNameValidator;
    private final Validator<String> roundValidator;
    private final Validator<CarNames> carCountValidator;

    public ValidatorFacade(Validator<String> carNameValidator, Validator<String> roundValidator,
                           Validator<CarNames> carCountValidator) {
        this.carNameValidator = carNameValidator;
        this.roundValidator = roundValidator;
        this.carCountValidator = carCountValidator;
    }

    public void validateCarNames(String carNamesInput) throws InvalidCarNameException {
        carNameValidator.validate(carNamesInput);
    }

    public void validateRoundCount(String roundInput) throws InvalidRoundException {
        roundValidator.validate(roundInput);
    }

    public void validateCarCount(CarNames carNames) throws InvalidCarCountException {
        carCountValidator.validate(carNames);
    }
}
