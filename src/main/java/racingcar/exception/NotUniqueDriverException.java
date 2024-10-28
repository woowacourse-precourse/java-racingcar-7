package racingcar.exception;

public class NotUniqueDriverException extends RacingCarException {
    private static final String MESSAGE = "드라이버의 이름은 중복될 수 없습니다";
    public NotUniqueDriverException() {
        super(MESSAGE);
    }
}
