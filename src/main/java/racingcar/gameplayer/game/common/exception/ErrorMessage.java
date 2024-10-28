package racingcar.gameplayer.game.common.exception;

public enum ErrorMessage {

    INVALID_NAME_FORMAT_ERROR("이름 입력 형식이 잘못되었습니다"),
    INVALID_COUNT_ERROR("횟수 입력 형식이 잘못되었습니다"),
    NAME_SHORT_LENGTH_ERROR("횟수 입력 형식이 잘못되었습니다"),
    INVALID_SCORE_STATUS("결과값이 존재하지 않습니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
