package racingcar.domain.exception;

public class InvalidCarInputException extends IllegalArgumentException {

    public InvalidCarInputException() {
        super("자동차 입력이 유효하지 않습니다.");
    }
}
