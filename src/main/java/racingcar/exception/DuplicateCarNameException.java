package racingcar.exception;

public class DuplicateCarNameException extends RuntimeException {

    public DuplicateCarNameException() {
        super("자동차 이름은 중복으로 지을 수 없습니다.");
    }
}
