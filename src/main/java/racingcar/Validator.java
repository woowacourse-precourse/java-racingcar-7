package racingcar;

public class Validator {
    private static final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하이어야 합니다.";
    private static final String GAME_COUNT_POSITIVE_ERROR_MESSAGE = "1 이상의 정수를 입력해주세요.";
    private static final String GAME_COUNT_FORMAT_ERROR_MESSAGE = "숫자로 변환할 수 없습니다.";

    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            validateCarNameLength(name);
        }
    }

    private static void validateCarNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    public static void validateGameCount(String count) {
        try {
            int gameCount = Integer.parseInt(count);
            validateGameCountPositive(gameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GAME_COUNT_FORMAT_ERROR_MESSAGE);
        }
    }

    private static void validateGameCountPositive(int gameCount) {
        if (gameCount < 1) {
            throw new IllegalArgumentException(GAME_COUNT_POSITIVE_ERROR_MESSAGE);
        }
    }
}
