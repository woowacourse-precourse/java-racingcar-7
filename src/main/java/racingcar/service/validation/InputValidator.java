package racingcar.service.validation;

import racingcar.view.messages.ErrorMessageEnum;

public interface InputValidator<T> {
    void validate(T value);

    default void checkEmpty(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageEnum.EMPTY_ERROR.getErrorMessage());
        }
    }
}