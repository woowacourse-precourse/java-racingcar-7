package racingcar.exception;

public class EmptyInputException extends RuntimeException {
    public EmptyInputException() {
        super("빈 입력값은 불가합니다.");
    }
}
