package racingcar.car.exception;

// 자동차 상태 관련 예외 처리 클래스
public class CarStatusException extends IllegalArgumentException {
    public CarStatusException(String message) {
        super(message);
    }
}
