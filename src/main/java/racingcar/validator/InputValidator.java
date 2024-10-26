package racingcar.validator;

public class InputValidator {
    private static final String CAR_NAME_SEPARATOR = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_REGEX = "[a-zA-Z가-힣]+";

    public static void validateCarNames(String input) {
        validateNotEmpty(input);

        validateContainsComma(input);

        String[] carNames = input.split(CAR_NAME_SEPARATOR);
        for (String carName : carNames) {
            validateNotEmpty(carName);

            validateCarNameLength(carName);

            validateCarNameCharacters(carName);
        }
    }

    public static int validateRound(String input) {
        validateNotEmpty(input);

        validateIsNumeric(input);

        int round = Integer.parseInt(input);
        validateIsPositive(round);

        return round;
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력이 없는 경우");
        }
    }

    private static void validateContainsComma(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("쉼표(,)가 포함되지 않은 경우");
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름이 " + MAX_CAR_NAME_LENGTH + "자를 초과하는 경우");
        }
    }

    private static void validateCarNameCharacters(String carName) {
        if (!carName.matches(CAR_NAME_REGEX)) {
            throw new IllegalArgumentException("자동차 이름에 알파벳이나 한글 이외의 문자(숫자나 특수문자)가 포함된 경우");
        }
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자가 아닌 경우");
        }
    }

    private static void validateIsPositive(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException("양수가 아닌 경우");
        }
    }
}
