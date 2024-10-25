package racingcar.exception;

public class InvalidRegisterCarsInputLengthException extends RuntimeException {
    public InvalidRegisterCarsInputLengthException() {
        super("자동차를 등록할 때 입력값은 1,000자 이하만 가능합니다.");
    }
}
