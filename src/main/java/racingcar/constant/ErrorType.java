package racingcar.constant;

public class ErrorType {

    public static final String PREFIX = "[ERROR] ";
    public static final String EXCEEDED_MAX_CAR_NAME_LENGTH = PREFIX + String.format("자동차 이름은 %d글자 이하여야 합니다.",
            Rule.CAR_NAME_LENGTH_MAX);
    public static final String INVALID_CAR_NAME = PREFIX + "자동차 이름은 공백 또는 빈문자열이 될 수 없습니다.";
    public static final String EXCEEDED_MAX_CARS_SIZE =
            PREFIX + String.format("자동차의 대수는 %d이하여야 합니다.", Rule.CAR_MAX_SIZE);
    public static final String EXCEEDED_MAX_COUNT = PREFIX + String.format("시도 횟수는 %d이하여야 합니다.", Rule.COUNT_MAX);
    public static final String INVALID_COUNT = PREFIX + "시도 횟수는 숫자여야 합니다.";
    public static final String DUPLICATE_CAR_NAME = PREFIX + "자동차 이름은 중복될 수 없습니다.";

    private ErrorType() {

    }
}
