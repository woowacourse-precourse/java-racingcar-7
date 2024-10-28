package racingcar.controller.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.exception.ErrorBase.INPUT_IS_EMPTY;

import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorBase;

public abstract class ValidatorTest<T> {
    protected abstract Validator<T> getValidator();

    @Test
    void 빈_문자열을_입력받으면_예외를_발생시킨다() {
        String input = "";

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_EMPTY.getMessage());
    }

    @Test
    void 공백_문자열을_입력받으면_예외를_발생시킨다() {
        String input = "    ";

        assertThatThrownBy(() -> getValidator().validate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_IS_EMPTY.getMessage());
    }
}