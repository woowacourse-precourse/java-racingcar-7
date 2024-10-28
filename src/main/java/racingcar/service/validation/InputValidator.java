package racingcar.service.validation;

import racingcar.service.utils.ExceptionUtils;
import racingcar.view.messages.ErrorMessageEnum;

public interface InputValidator<T> {
    void validate(T value);

    default void checkEmpty(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            ExceptionUtils.throwIllegalArgumentException(ErrorMessageEnum.EMPTY_ERROR);
        }
    }
}