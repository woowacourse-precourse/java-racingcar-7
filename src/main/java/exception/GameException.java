package exception;

/**
 * Enumeration of exceptions that can occur during game execution.
 * Contains validation messages for various game-related error scenarios.
 */
public enum GameException {
    UNDER_FIVE_LETTERS("이름의 길이는 5글자 이하여야합니다."),
    DUPLICATE_PARTICIPANTS("중복된 참가자가 존재합니다."),
    SINGLE_PARTICIPANTS("혼자서는 경기를 진행할 수 없습니다."),
    POSITIVE_TIMES("시도 횟수는 양의 정수만 입력 가능합니다."),
    NUMERIC_TIMES("시도 횟수는 숫자만 입력 가능합니다.");

    private final String message;

    /**
     * Constructs a GameException with the specified error message.
     *
     * @param message the detailed message describing the exception
     */
    GameException(String message) {
        this.message = message;
    }

    /**
     * Returns the error message associated with this exception.
     *
     * @return the error message string
     */
    public String getMessage() {
        return message;
    }
}