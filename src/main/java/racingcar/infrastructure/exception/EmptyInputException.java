package racingcar.infrastructure.exception;

public class EmptyInputException extends IllegalArgumentException {
    public EmptyInputException() {
        super("입력 값은 최소 한 글자 이상이어야 합니다.");
    }
}
