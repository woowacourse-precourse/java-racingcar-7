package racingcar;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.ExceptionMessage.INVALID_RANGE_ROUND_SIZE;
import static racingcar.ExceptionMessage.INVALID_TYPE_ROUND_SIZE;
import static racingcar.Rounds.MAX_ROUND_COUNT;
import static racingcar.Rounds.MIN_ROUND_COUNT;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundsTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "20"})
    void 시도_횟수가_1_이상_20이하의_정수이면_예외가_발생하지_않는다(String count) {
        assertThatCode(() -> new Rounds(count))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "21"})
    void 시도_횟수가_1_미만_20_초과의_정수이면_예외가_발생한다(String count) {
        assertThatThrownBy(() -> new Rounds(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(INVALID_RANGE_ROUND_SIZE.getMessage(), MIN_ROUND_COUNT, MAX_ROUND_COUNT));
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "-1.5", "1.0"})
    void 시도_횟수가_정수_외_타입이면_예외가_발생한다(String count) {
        assertThatThrownBy(() -> new Rounds(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_TYPE_ROUND_SIZE.getMessage());
    }

}