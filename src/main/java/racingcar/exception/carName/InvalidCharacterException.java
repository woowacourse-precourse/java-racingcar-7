package racingcar.exception.carName;

public class InvalidCharacterException extends IllegalArgumentException{

    public InvalidCharacterException() {
        super("쉼표를 제외한 특수문자는 사용이 불가합니다.");
    }
}
