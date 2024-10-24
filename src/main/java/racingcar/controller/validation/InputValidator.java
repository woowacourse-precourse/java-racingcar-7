package racingcar.controller.validation;

import racingcar.view.messages.ErrorMessageEnum;

public interface InputValidator<T> { // TODO: validation 디렉토리가 controller일지 service일지 고민..
    int validate(T value);

    // TODO: try-catch로 수정?
    default void checkEmpty(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageEnum.EMPTY_ERROR.getErrorMessage());
        }
    }
}