package racingcar;

public enum ExceptionMessage {
    CAR_MOVEMENT_COUNT_EMPTY_EXCEPTION("자동차 이동 횟수는 공백이 아니어야합니다."),
    CAR_MOVEMENT_COUNT_NOT_NATURAL_NUMBER_EXCEPTION("자동차 이동 횟수는 자연수이어야 합니다."),
    CAR_NAME_LENGTH_EXCEPTION("자동차 이름은 5자 이하이어야 합니다.");

    private String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String message() {
        return exceptionMessage;
    }
}
