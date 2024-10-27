package racingcar.infrastructure.constant;

public class ExceptionMessage {
    public static final String DUPLICATE_NAME = "입력 값은 서로 중복될 수 없습니다.";
    public static final String EMPTY_INPUT = "입력 값은 최소 한 글자 이상이어야 합니다.";
    public static final String EMPTY_NAME = "자동차 이름은 공백으로 설정할 수 없습니다.";
    public static final String INVALID_NAME_LENGTH = String.format(
            "자동차의 이름은 %d글자 이하로 입력해야 합니다.", CarConstants.MAX_LEN);
    public static final String INVALID_NUMBER_FORMAT = "숫자 형식이 올바르지 않습니다.";
    public static final String INVALID_NUMBER_RANGE = "양의 정수만 입력할 수 있습니다.";
    public static final String EXCEED_NUMBER = String.format("숫자는 최대 %d 까지 입력할 수 있습니다.", Boundary.REPEAT_MAX);
}
