package racingcar.common.exception;

public enum ErrorMessage {

    CAR_POSITION_OUT_OF_RANGE("자동차가 더 이상 전진할 수 없습니다.");

    private final String description;

    ErrorMessage(String description) {
        this.description = description;
    }
}
