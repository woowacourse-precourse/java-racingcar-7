package racingcar.exception;

public class InvalidLengthException extends IllegalArgumentException {
    public InvalidLengthException() {
        super("이름은 5자 이하만 작성 가능합니다.");
    }
}
