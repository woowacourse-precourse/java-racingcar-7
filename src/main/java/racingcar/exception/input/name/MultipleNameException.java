package racingcar.exception.input.name;


import racingcar.constant.error.ErrorNameConstant;

public class MultipleNameException extends IllegalArgumentException {
    public MultipleNameException() {
        super(ErrorNameConstant.ERROR_MULTIPLE_NAME);
    }
}