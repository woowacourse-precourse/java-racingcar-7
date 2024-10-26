package racingcar.exception.input.count;

import racingcar.constant.error.ErrorCountConstant;

public class TypeMissCountException extends IllegalArgumentException{
    public TypeMissCountException() {
        super(ErrorCountConstant.ERROR_TYPE_MISS_COUNT);
    }
}
