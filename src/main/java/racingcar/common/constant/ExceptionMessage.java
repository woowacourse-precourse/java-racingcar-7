package racingcar.common.constant;

public final class ExceptionMessage {

    private ExceptionMessage() {

    }

    public static final String NAME_OVER_LENGTH = "자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다";
    public static final String NO_COUNT_NUMBER_FORMAT = "시도할 횟수로 양의 정수를 입력해주세요.";
    public static final String NAME_BLANK = "자동차 이름은 비어있는 값으로 입력할 수 없습니다.";
    public static final String DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다.";
}
