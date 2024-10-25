package racingcar.view;

public class InputValidator {

    private static final String DELIMITER = ",";

    public static void validateNameOfCars(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 빈 문자열이어서는 안됩니다.");
        }

        if (containsOnlyDelimiter(input)) {
            throw new IllegalArgumentException("자동차의 이름은 구분자인 쉼표(,)로만 이루어질 수 없습니다.");
        }

        if (input.endsWith(DELIMITER)) {
            throw new IllegalArgumentException("자동차의 이름은 구분자인 쉼표(,)로 끝나서는 안됩니다.");
        }
    }

    public static void validateTotalRounds(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("시도할 횟수는 빈 값을 입력하실 수 없습니다.");
        }

        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException("시도할 횟수는 양의 정수 형태로 입력하셔야 합니다.");
        }
    }

    private static boolean containsOnlyDelimiter(String input) {
        return input.replace(DELIMITER, "").isBlank();
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches("^[1-9]\\d*$");
    }
}
