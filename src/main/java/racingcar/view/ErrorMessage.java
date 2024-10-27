package racingcar.view;

public enum ErrorMessage {
    NULL_INPUT("입력값이 필요합니다."),
    BLANK_INPUT("입력값은 공백이 될 수 없습니다."),
    NAME_LENGTH_OUT_OF_RANGE("자동차의 이름은 5자 이하여야 합니다."),
    NAME_INAPPROPRIATE("자동차의 이름은 공백이 될 수 없습니다."),
    INVALID_RACINGCAR_NUMBER("자동차의 수는 2 이상이어야 합니다."),
    DUPLICATED_RACINGCAR("같은 이름을 가진 자동차가 경주에 참여하였습니다."),
    INVALID_ROUND_COUNT("시도할 횟수는 숫자여야합니다."),
    ROUND_COUNT_OUT_OF_RANGE("시도할 횟수는 1 이상이어야합니다."),
    NO_MORE_ROUND("더 이상 시도할 횟수가 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}