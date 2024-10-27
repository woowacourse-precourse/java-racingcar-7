package util.validator;

import java.util.List;
import java.util.Arrays;

public class CarNameValidator {
    public enum ErrorMessage {
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

    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_OR_NULL_NAME.getMessage());
        }

        List<String> carNames = Arrays.asList(input.split(","));
        validateDelimiterAndSingleName(input);
        validateNameLength(carNames);
    }

    private void validateDelimiterAndSingleName(String input) {
        List<String> carNames = Arrays.asList(input.split(","));
        if (carNames.size() == 1) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_SINGLE_CAR_NAME.getMessage());
        }
        else throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
    }

    private void validateDelimiter(List<String> carNames, String input) {
        if (carNames.size() == 1 || !input.contains(",")) {
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

