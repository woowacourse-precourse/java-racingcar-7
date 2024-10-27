package racingcar.car.constant;

public final class ErrorMessage {

    public static final String EMPTY_STRING_NAME_ERROR_MESSAGE = "빈 문자 또는 공백은 자동차의 이름이 될 수 없습니다.";
    public static final String NAME_LENGTH_ERROR_MESSAGE = "이름의 길이는 5글자 이하만 가능합니다.";
    public static final String NAME_COUNT_ERROR_MESSAGE = "이름을 2개 이상 입력해야 합니다.";
    public static final String DUPLICATED_NAME_ERROR_MESSAGE = "중복된 이름을 입력하면 안됩니다.";
    public static final String ILLEGAL_RANDOM_NUMBER_COUNT_MESSAGE = "랜덤 넘버의 갯수와 자동차의 갯수는 동일해야 합니다.";

    private ErrorMessage() {
    }
}
