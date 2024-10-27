package racingcar.exceptions;

public class InvalidInputException extends IllegalArgumentException {
    public InvalidInputException() {
        super("유효하지 않은 입력입니다.");
    }
}
