package racingcar.validator;

import racingcar.message.ErrorMessage;

public class TryNumbersValidator {

    public Long validate(String tryNums) {
        validateBlank(tryNums);
        validateNumeric(tryNums);
        return Long.parseLong(tryNums);
    }

    public void validateNumeric(String tryNums) {
        for (char num : tryNums.toCharArray()) {
            if (!Character.isDigit(num)) {
                throw new IllegalArgumentException(ErrorMessage.TRY_NUM_NOT_NUMERIC_ERROR.getMessage());
            }
        }
    }

    public void validateBlank(String tryNums) {
        if (tryNums.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.COMMON_INPUT_BLANK_ERROR.getMessage());
        }
    }

}
