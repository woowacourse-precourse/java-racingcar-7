package racingcar.validator;

public class CarErrorMessages {
    public static final String LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하이어야 합니다: ";
    public static final String DUPLICATE_NAME_ERROR_MESSAGE = "자동차 이름이 중복되었습니다: ";
    public static final String EMPTY_OR_NULL_NAME_ERROR_MESSAGE = "자동차 이름은 공백이거나 NULL일 수 없습니다.";
    public static final String INVALID_CHARACTER_ERROR_MESSAGE = "자동차 이름은 소문자 영어만 가능하며, 공백이 포함될 수 없습니다: ";
    public static final String LEADING_TRAILING_SPACE_ERROR_MESSAGE = "자동차 이름은 앞뒤 공백을 포함할 수 없습니다: '";
    public static final String COMMA_ENDING_ERROR_MESSAGE = "입력값은 콤마로 끝날 수 없습니다.";
}
