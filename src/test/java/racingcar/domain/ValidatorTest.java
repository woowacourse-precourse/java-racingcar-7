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
}
