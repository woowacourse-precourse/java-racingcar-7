package racingcar.exception;

public class BlankInputException extends IllegalArgumentException {

    public BlankInputException() {
        super("빈 문자열이나 공백을 입력할 수 없습니다.");
    }

}
