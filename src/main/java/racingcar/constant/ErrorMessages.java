package racingcar.constant;

public class ErrorMessages {
    public static final String BLANK_INPUT = "입력된 값이 없습니다.";
    public static final String BLANK_NAME = "자동차 이름은 비어있을 수 없습니다.";
    public static final String INVALID_NAME_LENGTH = "자동차 이름은 5자 이하로 입력해야 합니다.";
    public static final String INVALID_NAME_LIST_SIZE = "자동차 이름은 2개 이상 입력해야 합니다.";
    public static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";
    public static final String INVALID_TRY_COUNT_FORMAT = "시도할 횟수는 숫자만 입력 가능합니다.";
    public static final String INVALID_TRY_COUNT_MIN = "시도할 횟수는 1회 이상이어야 합니다.";

    private ErrorMessages() {
    }
}
