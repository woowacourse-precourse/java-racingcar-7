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

    void validateCarName(String carNames){
        for(String carName : split(carNames)){
            checkCarName(carName);
        }
    }

    private void checkCarName(String carName) {
        carNameValidator.inputMoreThanOneCharacter(carName);
        carNameValidator.inputNotMoreThanFiveCharacter(carName);
    }

    private String[] split(String carNames){
        return carNames.split(",");
    }
}
