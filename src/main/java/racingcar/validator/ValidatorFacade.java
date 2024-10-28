package racingcar.validator;

import racingcar.model.CarNames;
import racingcar.validator.exception.InvalidCarCountException;
import racingcar.validator.exception.InvalidCarNameException;
import racingcar.validator.exception.InvalidRoundException;

public class ValidatorFacade {
    private final CarNameValidator carNameValidator;
    private final RoundValidator roundValidator;
    private final CarCountValidator carCountValidator;

    public ValidatorFacade(CarNameValidator carNameValidator, RoundValidator roundValidator,
                           CarCountValidator carCountValidator) {
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
