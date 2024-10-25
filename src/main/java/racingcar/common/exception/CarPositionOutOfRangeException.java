package racingcar.common.exception;

public class CarPositionOutOfRangeException extends IllegalArgumentException {
    public CarPositionOutOfRangeException(String carName, int position) {
        super(ErrorMessage.CAR_POSITION_OUT_OF_RANGE + "[자동차 이름 : " + carName + " 현재 위치 : " + position + "]");
    }
}
