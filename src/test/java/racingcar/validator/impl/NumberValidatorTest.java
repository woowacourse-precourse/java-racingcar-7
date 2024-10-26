package racingcar.validator.impl;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberValidatorTest {
    NumberValidator numberValidator = new NumberValidator();

    @Test
    void 음수_입력() {
        // given
        String string = "-1";

        // when

        // then
        assertThatThrownBy(() -> numberValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("양수를 입력해주십시오.");
    }

    @Test
    void 숫자_이외_입력() {
        // given
        String string = "문자열 입력";

        // when

        // then
        assertThatThrownBy(() -> numberValidator.validate(string))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해주십시오.");
    }
}