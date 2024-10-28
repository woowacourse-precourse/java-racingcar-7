package racingcar.exception;

public class CarNameFormatException extends IllegalArgumentException {

    private static final String ERROR_MESSAGE = "자동차의 이름이 형식에 어긋났습니다.";

    public CarNameFormatException(String carName) {
        super(ERROR_MESSAGE + " 오류가 발생한 자동차의 이름 : " + carName);
    }
}
