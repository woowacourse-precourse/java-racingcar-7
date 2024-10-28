package racingcar.config.validation.exception;

public class NotFoundValidatorException extends IllegalArgumentException {

    public NotFoundValidatorException() {
        super("[Validator Exception] 일치하는 유효성 검사 클래스를 찾을 수 없습니다.");
    }
}
