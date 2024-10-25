package racingcar.constant;

public class ErrorMessage {
    private ErrorMessage() {}

    public static final String PREFIX = "[ERROR] ";
    public static final String CAR_NAME_MUST_BE_SPLIT_BY_COMMA = "자동차 이름은 쉼표(,) 기준으로 구분하여 입력해주세요.";
    public static final String CAR_NAME_MAX_LENGTH_IS_FIVE = "자동차 이름은 5자 이하로 입력해주세요.";
    public static final String RACE_COUNT_ONLY_CAN_NUMBER = "시도 횟수는 숫자만 입력 가능합니다.";
} // class