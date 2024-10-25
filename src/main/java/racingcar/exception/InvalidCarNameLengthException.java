package racingcar.exception;

public class InvalidCarNameLengthException extends IllegalArgumentException {
    public InvalidCarNameLengthException() {
        super("이름은 5자 이하만 작성 가능합니다.");
    }
}
