package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.Error.ONLY_INT_NUMBER;

class InputTest {
    @Test
    void 숫자가_아니면_예외() {
        assertThatThrownBy(() -> Input.convertToInt("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_INT_NUMBER.getMessage());

    }

    @Test
    void int_범위_예외() {
        assertThatThrownBy(() -> Input.convertToInt("1000000000000000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ONLY_INT_NUMBER.getMessage());

    }
}