package racingcar;

public class Constants {
    public static final int CAR_NAME_MAX_LENGTH = 5;
    public static final int MOVE_THRESHOLD = 4;
    public static final int RANDOM_NUMBER_MIN = 0;
    public static final int RANDOM_NUMBER_MAX = 9;

    // Error
    public static final String ERROR_NAME_LENGTH = "자동차 이름이 " + CAR_NAME_MAX_LENGTH + "글자를 초과해선 안됩니다.";
    public static final String ERROR_EMPTY_NAME = "자동차 이름이 비어있거나 공백입니다.";
    public static final String ERROR_MOVEMENT_ZERO = "시도횟수가 0 이하입니다.";
    public static final String ERROR_INVALID_FORMAT = "입력형식이 올바르지 않습니다. 콤마(,)로 끝나면 안됩니다.";
    public static final String ERROR_DUPLICATE_NAME = "자동차 이름이 중복되었습니다.";
    public static final String ERROR_INVALID_SEPARATOR = "자동차 이름은 쉼표(,)로만 구분해야 합니다.";
    public static final String ERROR_NON_NUMERIC = "시도 횟수는 숫자만 입력해야 합니다.";
}
