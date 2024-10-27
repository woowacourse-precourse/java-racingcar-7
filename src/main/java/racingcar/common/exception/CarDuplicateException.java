package racingcar.common.exception;

public class CarDuplicateException extends IllegalArgumentException {

    public CarDuplicateException(String carName) {
        super(ErrorMessage.DUPLICATE_CAR + "[자동차 이름 : " + carName + "]");
    }
}
