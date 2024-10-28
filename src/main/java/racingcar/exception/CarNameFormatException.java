package racingcar.exception;

public class CarNameFormatException extends IllegalArgumentException {

    public CarNameFormatException() {
        super("입력받은 자동차 이름은 쉼표(,)로 구분되어야 하고 반드시 알파벳, 숫자 또는 한글로 이루어져야 합니다.");
    }
}
