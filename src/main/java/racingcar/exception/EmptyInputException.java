package racingcar.exception;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super("빈 입력값은 불가합니다.");
    }
}
