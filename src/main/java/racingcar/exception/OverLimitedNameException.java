package racingcar.exception;

public class OverLimitedNameException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return "자동차 이름은 5글자 이내입니다.";
    }
}
