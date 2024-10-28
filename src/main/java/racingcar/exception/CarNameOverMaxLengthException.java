package racingcar.exception;

public class CarNameOverMaxLengthException extends IllegalArgumentException {

    static private final String DEFAULT_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";

    public CarNameOverMaxLengthException(String name) {
        super(DEFAULT_MESSAGE + " : " + name);
    }
}
