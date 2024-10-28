package racingcar;

public enum ErrorSubstance {
    CAR_NAME_EMPTY_VALUE("자동차 이름이 빈 값일 수 없습니다."),
    CAR_NAME_LETTER_EXCESS("자동차 이름은 5글자를 초과할 수 없습니다."),
    CAR_NAME_DUPLICATION("중복된 이름입니다."),
    CAR_NOT_COLLECT_COUNT("자동차는 2개 이상 입력해주세요."),
    TRY_TIME_INAPPROPRIATE("시도할 횟수에 숫자만 입력해주세요."),
    TRY_TIME_NOT_COLLECT_NUM("시도할 횟수는 1회 이상으로 입력해주세요.");

    private final String message;

    ErrorSubstance(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
