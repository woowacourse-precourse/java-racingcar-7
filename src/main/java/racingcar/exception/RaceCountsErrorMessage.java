package racingcar.exception;

public enum RaceCountsErrorMessage {
    COUNT_EMPTY("경기 횟수가 비어 있습니다."),
    COUNT_NOT_INTEGER("경기 횟수는 숫자여야 합니다."),
    COUNT_NEGATIVE("경기 횟수는 1회 이상이어야 합니다.");

    private final String message;

    RaceCountsErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
