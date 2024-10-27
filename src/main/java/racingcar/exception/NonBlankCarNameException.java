package racingcar.exception;

public class NonBlankCarNameException extends IllegalArgumentException {

    public NonBlankCarNameException() {
        super("자동차 이름에 빈 문자열은 허용되지 않습니다.");
    }
}
