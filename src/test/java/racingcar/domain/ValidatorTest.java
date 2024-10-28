package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 입력값이_비어있을_때_예외발생() {
        // given && when
        assertThatThrownBy(() -> Validator.validateInput(""))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_INPUT_ERROR);
    }

    @Test
    void 시도_횟수가_유효하지_않을_때_예외발생() {
        // given && when
        assertThatThrownBy(() -> Validator.validateTryCount("-1"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_TRY_COUNT_ERROR);

        // given && when
        assertThatThrownBy(() -> Validator.validateTryCount("0"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_TRY_COUNT_ERROR);

        // given && when
        assertThatThrownBy(() -> Validator.validateTryCount("abc"))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_TRY_COUNT_ERROR);

        // given && when
        assertThatThrownBy(() -> Validator.validateTryCount("   "))
        // then
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Validator.INVALID_TRY_COUNT_ERROR);
    }
}
