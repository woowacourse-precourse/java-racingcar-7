package racingcar.exception;

public class RaceCountsException extends IllegalArgumentException {
    public static final String MESSAGE_COUNT_EMPTY = "경기 횟수가 비어 있습니다.";
    public static final String MESSAGE_COUNT_NOT_INTEGER = "경기 횟수는 숫자여야 합니다.";
    public static final String MESSAGE_COUNT_NEGATIVE = "경기 횟수는 1회 이상이어야 합니다.";

    public RaceCountsException(String errorMessage) {
        super(errorMessage);
    }
}