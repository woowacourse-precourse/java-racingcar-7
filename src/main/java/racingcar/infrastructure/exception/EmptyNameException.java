package racingcar.infrastructure.exception;

public class EmptyNameException extends IllegalArgumentException {
    public EmptyNameException() {
        super("자동차 이름은 공백으로 설정할 수 없습니다.");
    }
}
