package util.validator;

import java.util.List;
import java.util.Arrays;

public class CarNameValidatorImpl implements CarNameValidator {
    private enum ErrorMessage {
        INVALID_DELIMITER("자동차 이름은 쉼표로 구분되어야 합니다."),
        INVALID_SINGLE_CAR_NAME("자동차는 2대 이상이어야 합니다."),
        INVALID_NAME_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
        EMPTY_OR_NULL_NAME("자동차 이름에 공백이나 null 값이 포함될 수 없습니다.");

        private final String message;

        ErrorMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    @Override
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_OR_NULL_NAME.getMessage());
        }

        List<String> carNames = Arrays.asList(input.split(","));
        validateSingleName(input);
        validateDelimiter(input);
        validateNameLength(carNames);
    }

    private void validateSingleName(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        if (!input.contains(",") && carNames.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SINGLE_CAR_NAME.getMessage());
        }
    }

    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }

    private void validateNameLength(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.trim().length() > 5) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
            }
        }
    }
}

