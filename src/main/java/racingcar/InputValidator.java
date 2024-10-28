package racingcar;

public class InputValidator {
    private final CarNameValidator carNameValidator;
    private final NumberValidator numberValidator;

    InputValidator(CarNameValidator carNameValidator, NumberValidator numberValidator) {
        this.carNameValidator = carNameValidator;
        this.numberValidator = numberValidator;
    }

    void validateCarNames(String carNames) {
        carNameValidator.separateByComma(carNames);
        carNameValidator.inputMoreThanTwo(carNames);
        carNameValidator.inputSameName(carNames);
    }
}
