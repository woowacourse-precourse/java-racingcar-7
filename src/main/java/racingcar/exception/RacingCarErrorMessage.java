package racingcar.exception;

public enum RacingCarErrorMessage {

    START_INPUT_ERROR("공백이 아닌 값을 입력해주세요."),
    CAR_NAME_LENGTH_ERROR("자동차 이름은 5자를 초과할 수 없습니다."),
    CAR_NAME_BLANK_ERROR("자동차 이름은 공백일 수 없습니다."),
    REPEAT_NUMBER_ERROR("반복 횟수는 양의 정수여야 합니다.");

    private final String errorMessage;

    RacingCarErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }
}
