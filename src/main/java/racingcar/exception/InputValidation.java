package racingcar.exception;

public final class InputValidation {

    private static final String NOT_CONTAIN_BLANK_MESSAGE = "공백을 입력할 수 없습니다.";
    private static final String BLANK = " ";

    private InputValidation() {
    }

    public static void validateCarNames(String carNames) {
        validate(carNames, "자동차 이름을 입력해야 합니다.");
    }

    public static void validateDelimiter(String[] splitCarNames) {
        for (String splitCarName : splitCarNames) {
            validate(splitCarName, "구분자를 연속해서 입력할 수 없습니다.");
        }
    }

    public static void validateRacingCount(String racingCount) {
        validate(racingCount, "시도 횟수를 입력해야 합니다.");
    }

    private static void validate(String input, String exceptionMessage) {
        if (InputValidation.validateNullOrEmpty(input)) {
            throw new IllegalArgumentException(exceptionMessage);
        }
        if (InputValidation.validateBlank(input)) {
            throw new IllegalArgumentException(NOT_CONTAIN_BLANK_MESSAGE);
        }
    }

    private static boolean validateNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private static boolean validateBlank(String input) {
        return input.contains(BLANK);
    }
}
