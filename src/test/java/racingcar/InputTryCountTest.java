package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.message.exception.IntConverterExceptionMessage.INPUT_VALUE_MINUS_OR_ZERO;
import static racingcar.message.exception.IntConverterExceptionMessage.INPUT_VALUE_OVERFLOW;

import org.junit.jupiter.api.Test;

@SuppressWarnings("NonAsciiCharacters")
public class InputTryCountTest extends ApplicationTest {
    @Test
    void 시도_횟수_음수() {
        assertThatThrownBy(() -> runException("pope,ki", "-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_VALUE_MINUS_OR_ZERO);
    }

    @Test
    void 시도_횟수_제로() {
        assertThatThrownBy(() -> runException("pope,ki", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_VALUE_MINUS_OR_ZERO);
    }

    @Test
    void 시도_횟수_오버플로우() {
        assertThatThrownBy(() -> runException("pope,ki", "2147483648"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INPUT_VALUE_OVERFLOW);
    }
}
