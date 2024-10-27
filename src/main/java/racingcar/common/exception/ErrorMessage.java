package racingcar.common.exception;

public final class ErrorMessage {

    public static final String INPUT_NULL_ERROR = "[Error] 값이 입력되지 않았습니다.";
    public static final String INPUT_BLANK_ERROR = "[Error] 빈 문자열은 입력할 수 없습니다.";

    public static final String TRIAL_COUNT_TYPE_ERROR = "[Error] 시도 횟수가 정수가 아닙니다.";
    public static final String TRIAL_COUNT_ZERO_OR_NEGATIVE_VALUE_ERROR = "[Error] 시도 횟수는 0 이상이여야 합니다.";

    public static final String CAR_NAME_NULL_ERROR = "[Error] 자동차 이름이 입력되지 않았습니다.";
    public static final String CAR_NAME_BLANK_ERROR = "[Error] 자동차 이름은 공백만으로 구성될 수 없습니다.";
    public static final String CAR_NAME_LENGTH_ERROR = "[Error] 자동차 이름은 5자 이하여야 합니다.";

    public static final String CAR_NAME_DUPLICATION_ERROR = "[Error] 경주할 자동차 이름은 모두 달라야 합니다.";
}
