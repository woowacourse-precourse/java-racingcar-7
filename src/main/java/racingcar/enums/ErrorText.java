package racingcar.enums;

public enum ErrorText {
    EMPTY_ATTEMPT_COUNT("시도 횟수를 입력하세요."),
    NON_POSITIVE_ATTEMPT_COUNT("시도 횟수는 양의 정수만 입력 가능합니다."),
    EMPTY_CAR_NAME("경주할 자동차 이름을 입력하세요."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME("자동차 이름이 중복되었습니다.");

    private final String errorText;

    ErrorText(String errorText) {
        this.errorText = errorText;
    }

    public String getErrorText() {
        return errorText;
    }
}
