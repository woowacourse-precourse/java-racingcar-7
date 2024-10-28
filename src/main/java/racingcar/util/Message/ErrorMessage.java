package racingcar.util.Message;

public class ErrorMessage {
    public static final String NAME_MAX_LENGTH_ERROR = "이름은 5글자 이하만 가능합니다.";
    public static final String NAME_MIN_LENGTH_ERROR = "이름은 1글자 이상만 가능합니다.";
    public static final String DUPLICATE_NAME_ERROR = "중복된 이름이 존재할 수 없습니다.";
    public static final String INVALID_DELIMITER_ERROR = "쉼표(',')외의 구분자는 허용하지 않습니다.";
    public static final String NOT_A_NUMBER_ERROR = "시도 횟수는 숫자만 입력 가능합니다.";
    public static final String TRIAL_MIN_COUNT_ERROR = "시도 횟수는 1이상만 입력 가능합니다.";
    public static final String INVALID_RANDOM_NUMBER_RANGE_ERROR = "허용되지 않은 랜덤한 숫자 범위입니다.";

    private ErrorMessage() {

    }
}
