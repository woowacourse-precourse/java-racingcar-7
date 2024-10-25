package racingcar.car.exception;

// 자동차 이름 관련 예외 처리 클래스
public class CarNameException extends IllegalArgumentException {
    public CarNameException(String message) {
        super(message);
    }
}

