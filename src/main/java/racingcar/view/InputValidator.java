package racingcar.view;

public class InputValidator {

    private static final String DELIMITER = ",";
    private static final String KOREAN_RANGE_OF_REGEX = "가-힣";
    private static final String ENGLISH_RANGE_OF_REGEX = "a-zA-Z";
    private static final String NUMBER_RANGE_OF_REGEX = "0-9";
    private static final String WHITESPACE_REGEX = "\\s";

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

        if (containsInvalidCharactersForNameOfCars(input)) {
            throw new IllegalArgumentException("자동차의 이름은 숫자, 알파벳, 한글만 가능합니다.");
        }
    }

    public static void validateTotalRounds(final String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("총 라운드는 빈 값을 입력하실 수 없습니다.");
        }

        if (isNotPositiveInteger(input)) {
            throw new IllegalArgumentException("총 라운드는 양의 정수 형태로 입력하셔야 합니다.");
        }
    }

    private static boolean containsOnlyDelimiter(String input) {
        return input.replace(DELIMITER, "").isBlank();
    }

    private static boolean containsInvalidCharactersForNameOfCars(String input) {
        String pattern = "[" + KOREAN_RANGE_OF_REGEX + ENGLISH_RANGE_OF_REGEX + NUMBER_RANGE_OF_REGEX + DELIMITER
                + WHITESPACE_REGEX + "]*";
        return !input.matches(pattern);
    }

    private static boolean isNotPositiveInteger(String input) {
        return !input.matches("^[1-9]\\d*$");
    }
}
