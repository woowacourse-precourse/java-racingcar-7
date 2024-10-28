package racingcar.error;

public class ErrorMessageConstants {
    public static final String INVALID_CAR_NAME = "자동차 이름은 null이거나 공백일 수 없습니다.";
    public static final String CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String DUPLICATE_CAR_NAME = "자동차 이름은 중복될 수 없습니다: %s";
    public static final String NULL_CAR_IN_LIST = "Car 리스트에 null 값을 포함할 수 없습니다.";
    public static final String NULL_CAR_LIST = "Car 리스트가 null일 수 없습니다.";
    public static final String EMPTY_INPUT_ERROR = "입력값이 비어있습니다.";
    public static final String NON_NUMERIC_INPUT_ERROR = "시도 횟수는 숫자여야 합니다.";
    public static final String NON_POSITIVE_INTEGER_ERROR = "시도 횟수는 1 이상의 자연수여야 합니다.";

    private ErrorMessageConstants() {
        // 인스턴스화 방지
    }
}
