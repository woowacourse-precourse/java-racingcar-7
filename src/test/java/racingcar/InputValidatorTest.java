package racingcar;

import static org.assertj.core.api.Assertions.*;
import static racingcar.ExceptionMessage.*;
import static racingcar.InputValidator.MAX_CAR_NAME_LENGTH;
import static racingcar.InputValidator.MIN_CAR_NAME_LENGTH;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" crong", "loopy "})
    void 자동차명_맨앞이나_맨뒤의_공백은_글자수에서_제외한다(String carName) {
        assertThatCode(() -> InputValidator.validateCarName(carName))
                .doesNotThrowAnyException();
    }

    @Test
    void 자동차명이_null이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarName(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_CAR_NAME.getMessage());
    }

    @Test
    void 자동차명이_공백이면_예외가_발생한다() {
        assertThatThrownBy(() -> InputValidator.validateCarName(" "))
        .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BLANK_CAR_NAME.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"pororo", "javajigi", "abc de"})
    void 자동차명이_5자_초과이면_예외가_발생한다(String carName) {
        assertThatThrownBy(() -> InputValidator.validateCarName(carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_LENGTH_RANGE_CAR_NAME.getMessage(),
                        MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH, carName));
    }
}