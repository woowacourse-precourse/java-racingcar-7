package racingcar.Util.Exception;

public enum ErrorMessage {
    NAME_WHITESPACE("이름에 공백만 입력할 수 없습니다."),
    NAME_EMPTY("이름은 비어 있을 수 없습니다."),
    NAME_TOO_LONG("이름이 5글자 이상입니다."),
    NAME_DUPLICATE("이름이 중복되었습니다."),
    TRIAL_NOT_INTEGER("시도 횟수는 정수여야 합니다."),
    TRIAL_NEGATIVE("시도 횟수는 음수일 수 없습니다."),
    TRIAL_ZERO("시도 횟수는 0일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
