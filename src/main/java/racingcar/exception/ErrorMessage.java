package racingcar.exception;

public enum ErrorMessage {

    NULL_EMPTY_FOUND("Null 혹은 공백 문자가 포함되었습니다."),
    OVER_LENGTH_FOUND("자동차 이름 길이가 5를 초과했습니다."),
    REGEX_FOUND("특수 문자가 포함되었습니다."),
    SAME_NAME_FOUND("동일한 이름의 자동차가 존재합니다."),
    OVER_GAME_MATCHES("허용된 게임 횟수를 넘겼습니다."),
    NEGATIVE_GAME_MATCHES("경기 횟수는 음수가 될 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
