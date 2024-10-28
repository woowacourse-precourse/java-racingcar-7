package racingcar.util;

public class Validator {

    // 자동차 이름 유효성 검사
    public static void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.isEmpty()) {
                throw new IllegalArgumentException(Constants.CAR_NAME_NOT_EMPTY);
            }

            if (name.length() > Constants.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(Constants.CAR_NAME_MAX_LENGTH);
            }

            if (name.contains(Constants.BLANK)) {
                throw new IllegalArgumentException(Constants.CAR_NAME_NOT_CONTAINS_BLANK);
            }
        }
    }

    // 시도 횟수 유효성 검사
    public static void validateTryCnt(String input) {
        try {
            int tryCnt = Integer.parseInt(input);
            if (tryCnt <= 0)
                throw new IllegalArgumentException(Constants.TRY_COUNT_MIN_VALUE);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.TRY_COUNT_NUMERIC);
        }
    }
}
