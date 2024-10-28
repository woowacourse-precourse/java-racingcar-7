package racingcar.exception;

public class ExceptionMessage {

    public static final String INVALID_CAR_NAME = "자동차 이름을 올바르게 입력해주세요. 공백이나 빈 문자열은 허용하지 않습니다.";
    public static final String CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String DUPLICATE_CAR_NAME_ERROR = "자동차 이름은 중복될 수 없습니다.";
    public static final String EMPTY_INPUT_ERROR = "공백이나 빈 문자열은 허용하지 않습니다.";
    public static final String INVALID_COMMA_POSITION = "입력 값의 맨 앞이나 맨 뒤에 쉼표가 올 수 없습니다.";
    public static final String EMPTY_ROUNDS_ERROR = "전진 횟수는 빈 값이나 공백일 수 없습니다.";
    public static final String NON_POSITIVE_ROUNDS_ERROR = "시도할 횟수는 1 이상이어야 합니다.";
    public static final String INVALID_NUMBER_ERROR = "유효한 숫자를 입력해주세요.";
}
