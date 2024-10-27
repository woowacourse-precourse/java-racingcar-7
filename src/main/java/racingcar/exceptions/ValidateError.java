package racingcar.exceptions;

public class ValidateError {
    private static final String INVALID_DELIMITER = "구분자는 쉼표만 가능합니다.";
    private static final String NO_EXIST_TRY_NUMBER = "시도 횟수를 입력해주세요.";
    private static final String NO_EXIST_CAR_NAME = "자동차의 이름을 입력해주세요.";
    private static final String NEGATIVE_TRY_NUMBER = "시도 횟수는 양수만 가능합니다.";
    private static final String INVALID_TRY_NUMBER = "시도 횟수는 숫자만 입력이 가능합니다.";
    private static final String EXCEED_CAR_NAME_LIMIT = "자동차의 이름은 5자 이하만 가능합니다.";

    public static void validateCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(NO_EXIST_CAR_NAME);
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(EXCEED_CAR_NAME_LIMIT);
        }
    }

    public static void validateTryNumber(String tryNumStr) {
        if (tryNumStr == null || tryNumStr.isEmpty()) {
            throw new IllegalArgumentException(NO_EXIST_TRY_NUMBER);
        }
        try {
            int tryNum = Integer.parseInt(tryNumStr);
            if (tryNum <= 0) {
                throw new IllegalArgumentException(NEGATIVE_TRY_NUMBER);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_TRY_NUMBER);
        }
    }
}
