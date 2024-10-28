package racingcar.validator;

import racingcar.util.Separator;

public class InputValidator {
    private final CarNamesValidator carNamesValidator;
    private final CarNameValidator carNameValidator;
    private final NumberValidator numberValidator;

    public InputValidator(CarNamesValidator carNamesValidator,
                          CarNameValidator carNameValidator,
                          NumberValidator numberValidator) {
        this.carNamesValidator = carNamesValidator;
        this.carNameValidator = carNameValidator;
        this.numberValidator = numberValidator;
    }

    public void validateCarNames(String carNames) {
        inputBlank(carNames);
        carNamesValidator.separateByComma(carNames);
        carNamesValidator.inputMoreThanTwo(carNames);
        carNamesValidator.inputSameName(carNames);
    }

    public void validateCarName(String carNames) {
        for(String carName : Separator.split(carNames)){
            checkCarName(carName);
        }
    }

    public void validateNumber(String number) {
        inputBlank(number);
        numberValidator.inputPositiveNumber(Integer.parseInt(number));
    }

    private void checkCarName(String carName) {
        inputBlank(carName);
        carNameValidator.inputNotMoreThanFiveCharacter(carName);
    }

    private void inputBlank(String carName) {
        if (isBlank(carName)) {
            throw new IllegalArgumentException("공백이 아닌 자동차 이름 혹은 숫자를 입력해주세요");
        }
    }

    private boolean isBlank(String carName) {
        return carName == null || carName.trim().isEmpty();
    }
}
