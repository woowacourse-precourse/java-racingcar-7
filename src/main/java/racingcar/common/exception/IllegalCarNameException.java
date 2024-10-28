package racingcar.common.exception;

public class IllegalCarNameException extends IllegalArgumentException {

    public IllegalCarNameException(String carName) {
        super(ErrorMessage.CAR_NAME_EMPTY + "[자동차 이름 : " + carName + "]");
    }

    public IllegalCarNameException(String carName, int length) {
        super(ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE + "[자동차 이름 : " + carName + " 자동차 이름 길이 : " + length + "]");
    }

}
