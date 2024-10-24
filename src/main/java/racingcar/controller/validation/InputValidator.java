package racingcar.controller.validation;

import racingcar.view.messages.ErrorMessageEnum;

public interface InputValidator<T> {
    void validate(T value);

    // TODO: try-catch로 수정?
    default void checkEmpty(String value) throws IllegalArgumentException {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessageEnum.EMPTY_ERROR.getErrorMessage());
        }
    }
}
// T가 머냐
// TODO: 시도 횟수 + 입력 이름들은 어떻게 관리할겨?
// TODO: Car.setName 어디서 할겨?