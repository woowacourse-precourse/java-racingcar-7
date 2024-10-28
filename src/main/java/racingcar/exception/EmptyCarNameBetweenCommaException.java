package racingcar.exception;

public class EmptyCarNameBetweenCommaException extends IllegalArgumentException {

    private final static String ERROR_MESSAGE = "쉼표와 쉼표 사이에 이름을 입력해야 합니다.";
    public EmptyCarNameBetweenCommaException() {
        super(ERROR_MESSAGE);
    }
}
