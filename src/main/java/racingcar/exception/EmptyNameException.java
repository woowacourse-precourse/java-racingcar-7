package racingcar.exception;

public class EmptyNameException extends IllegalArgumentException{

    @Override
    public String getMessage() {
        return "유효하지 않은 이름입니다. 공백은 이름이 될 수 없습니다.";
    }
}
