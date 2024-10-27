package racingcar.domain;

public enum ErrorMessage {
    ATTEMPT_RANGE("시도 횟수는 1~100까지 입력 가능합니다."),
    ATTEMPT_ONLY_NUMBER("시도 횟수는 숫자로 입력해주세요."),

    CAR_NAME_MAX("자동차 이름은 5자 이하까지 입력 가능합니다."),
    CAR_NAME_BLANK("공백으로 입력된 이름이 있습니다."),
    CAR_NAME_CONTAIN_SPECIAL_CHARACTER("자동차 이름에 특수문자는 사용 불가합니다."),
    CAR_QUANTITY_MAX("자동차는 최대 50대까지만 입력 가능합니다."),
    CAR_NAME_DUPLICATE("중복된 자동차 이름이 있습니다."),
    INPUT_CAR_EMPTY("입력된 자동차 이름이 없습니다. 최소 1대 이상 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
