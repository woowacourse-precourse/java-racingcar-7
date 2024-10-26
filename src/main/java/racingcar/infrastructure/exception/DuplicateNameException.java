package racingcar.infrastructure.exception;

public class DuplicateNameException extends IllegalArgumentException {
    public DuplicateNameException() {
        super("입력 값은 서로 중복될 수 없습니다.");
    }
}
