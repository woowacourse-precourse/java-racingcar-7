package racingcar.validator;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;
import racingcar.validator.exception.InvalidCarNameException;
import racingcar.validator.exception.InvalidRoundException;

public class ValidatorFacade {
    private final Validator<CarNames> carNameValidator;
    private final Validator<String> roundValidator;
    private final Validator<CarNames> carCountValidator;

    public ValidatorFacade(Validator<CarNames> carNameValidator, Validator<String> roundValidator,
                           Validator<CarNames> carCountValidator) {
        this.carNameValidator = carNameValidator;
        this.roundValidator = roundValidator;
        this.carCountValidator = carCountValidator;
    }

    public void validateCarNames(CarNames carNamesInput) throws InvalidCarNameException {
        carNameValidator.validate(carNamesInput);
    }

    public void validateRoundCount(String roundInput) throws InvalidRoundException {
        roundValidator.validate(roundInput);
    }

    public void validateCarCount(CarNames carNames) throws InvalidCarCountException {
        carCountValidator.validate(carNames);
    }
}
