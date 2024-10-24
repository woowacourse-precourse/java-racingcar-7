package racingcar.exception;

public class CarNameFormatException extends IllegalArgumentException {

    private static final String message = "자동차의 이름이 형식에 어긋났습니다.";

    public CarNameFormatException(String carName) {
        super(message + " 오류가 발생한 자동차의 이름 : " + carName);
    }
}
