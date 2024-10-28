package racingcar;

public enum ErrorMessage {

    CAR_INPUT_EMPTY("경주할 자동차 이름을 입력하여야 합니다"),
    INSUFFICIENT_MIN_CAR_COUNT("1대 이상의 자동차가 경주에 참여해야 합니다"),

    ROUND_INPUT_EMPTY("시도할 횟수를 입력해야 합니다"),
    ROUND_INPUT_TYPE_NOT_MATCH("시도할 횟수 입력은 숫자여야 합니다"),
    INSUFFICIENT_MIN_ROUND("라운드는 1회 이상 진행되어야 합니다"),

    CAR_NAME_LENGTH_OVER("자동차 이름은 5자리 이하여야합니다"),

    CAN_NOT_FOUND_WINNER("우승자를 찾을 수 없음"),
    ;

    private String msg;

    private ErrorMessage(String msg) {
        this.msg = msg;
    }

    public String getMessage() {
        return msg;
    }
}
