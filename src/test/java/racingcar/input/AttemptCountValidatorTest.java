package racingcar.input;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorCode;

class AttemptCountValidatorTest {

    @Test
    void 유효한_시도_횟수는_예외가_발생하지_않는다() {
        // when & then
        assertThatCode(() -> AttemptCountValidator.validate(1))
                .doesNotThrowAnyException();

        assertThatCode(() -> AttemptCountValidator.validate(5))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효하지_않은_시도_횟수는_예외가_발생한다() throws NoSuchFieldException, IllegalAccessException {
        // given
        int minAttemptCount = getMinAttemptCount();
        String expectedMessage = ErrorCode.INVALID_ATTEMPT_COUNT.getMessage(minAttemptCount);

        // when & then
        assertThatThrownBy(() -> AttemptCountValidator.validate(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);

        assertThatThrownBy(() -> AttemptCountValidator.validate(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expectedMessage);
    }

    private int getMinAttemptCount() throws NoSuchFieldException, IllegalAccessException {
        Field minAttemptCountField = AttemptCountValidator.class.getDeclaredField("MIN_ATTEMPT_COUNT");
        minAttemptCountField.setAccessible(true);
        return (int) minAttemptCountField.get(null);
    }
}
