package racingcar.config.exception.input.name;


import racingcar.config.constant.error.ErrorNameConstant;

public class MultipleNameException extends IllegalArgumentException {
    public MultipleNameException() {
        super(ErrorNameConstant.ERROR_MULTIPLE_NAME);
    }
}