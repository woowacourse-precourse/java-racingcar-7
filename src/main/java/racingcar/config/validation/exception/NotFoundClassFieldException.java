package racingcar.config.validation.exception;

public class NotFoundClassFieldException extends IllegalArgumentException {

    public NotFoundClassFieldException() {
        super("클래스 필드를 찾지 못했습니다.");
    }
}
