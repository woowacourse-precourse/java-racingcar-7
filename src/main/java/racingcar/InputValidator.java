package racingcar;

import racingcar.enums.ErrorText;
import racingcar.enums.Limits;

import java.util.LinkedHashMap;

public class InputValidator {
    final String inputText;

    public InputValidator(String inputText) {
        this.inputText = inputText;
    }

    public void carNameValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException(ErrorText.EMPTY_CAR_NAME.getErrorText());
        } else if (isCarNameTooLong()) {
            throw new IllegalArgumentException(ErrorText.CAR_NAME_TOO_LONG.getErrorText());
        }
    }

    public void attemptCountValidator() {
        if (isBlankInput()) {
            throw new IllegalArgumentException(ErrorText.EMPTY_ATTEMPT_COUNT.getErrorText());
        } else if (isPositiveValue()) {
            throw new IllegalArgumentException(ErrorText.NON_POSITIVE_ATTEMPT_COUNT.getErrorText());
        }
    }

    private LinkedHashMap<Car, Integer> splitInputText() {
        return new InputParser(inputText).splitByComma();
    }

    private boolean isBlankInput() {
        return inputText.isBlank();
    }

    private boolean isCarNameTooLong() {
        for (Car car : splitInputText().keySet()) {
            if (car.getCarName().length() > Limits.MAX.getValue()) {
                return true;
            }
        }
        return false;
    }

    private boolean isPositiveValue() {
        try {
            long value = Long.parseLong(inputText);
            return value < 0;
        } catch (NumberFormatException e) {
            return true;
        }
    }
}