package racingcar.exception;

/**
 * ErrorMessage
 * - 에러 메시지 관리
 */
public enum ErrorMessage {
    EMPTY_CAR_NAME("자동차 이름을 입력해야 합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다."),
    INVALID_CAR_NAME_SPACE("자동차 이름에 내부 공백이 포함될 수 없습니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    INVALID_TRIAL_COUNT("시도 횟수는 1 이상의 정수로 입력해야 합니다."),
    INVALID_NUMBER_FORMAT("시도 횟수는 숫자 형식으로 입력해야 합니다.")
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
