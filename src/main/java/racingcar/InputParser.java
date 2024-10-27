package racingcar;

import static racingcar.Constants.*;

public class InputParser {
    private final InputValidator validator = new InputValidator();

    public String[] executeCarNames(String input) {
        validator.checkNull(input);
        validator.checkEndsWithComma(input);
        String[] carNames = input.split(CAR_NAME_DELIMITER);
        validator.checkMaxSize(carNames);
        validateEachCarName(carNames);
        validator.checkDuplicate(carNames);
        return carNames;
    }

    public int executeAttempts(String input) {
        validator.checkNull(input);
        int attempts = validator.toInteger(input);
        validator.checkRange(attempts);
        return attempts;
    }

    private void validateEachCarName(String[] carNames) {
        for (String carName : carNames) {
            validator.checkNameLength(carName);
            validator.checkEmptyName(carName);
            validator.checkAsciiCode(carName);
            validator.checkNotBlank(carName);
        }
    }
}
