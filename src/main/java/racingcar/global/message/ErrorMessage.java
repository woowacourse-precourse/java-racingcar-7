package racingcar.global.message;

public enum ErrorMessage {

    INVALID_TRY_COUNT_FORMAT("시도 횟수는 숫자로 입력해주세요."),
    INVALID_TRY_COUNT_VALUE("시도 횟수는 1 이상이여야 합니다."),
    DUPLICATE_CAR_NAME("중복된 자동차 이름이 있습니다."),
    EMPTY_CAR_NAME("자동차 이름이 빈 문자열일 수 없습니다."),
    CONSECUTIVE_COMMAS("자동차 이름 사이에 연속된 쉼표가 있습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자를 넘을 수 없습니다."),
    CAR_NAME_INVALID_CHARACTERS("자동차 이름은 영어 알파벳으로만 구성되어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}
