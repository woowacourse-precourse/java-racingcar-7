package racingcar.exception;

public class InvalidDriverNamesException extends RacingCarException{
    private static final String MESSAGE = "드라이버의 이름은 공백없이 5글자 이하로 해주십시오.";
    public InvalidDriverNamesException() {
        super(MESSAGE);
    }
}
