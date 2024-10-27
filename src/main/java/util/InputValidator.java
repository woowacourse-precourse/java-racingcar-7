package util;

public class InputValidator {
    public enum ErrorMessage {
        EMPTY_OR_NULL_NAME("자동차 이름에 공백이나 null 값이 포함될 수 없습니다."),
        INVALID_DELIMITER("자동차 이름은 쉼표로 구분되어야 합니다.");

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

        validateDelimiter(input);
    }

    private void validateDelimiter(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_DELIMITER.getMessage());
        }
    }
}
