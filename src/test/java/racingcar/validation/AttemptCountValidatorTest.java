package racingcar.validation;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThatCode;

class AttemptCountValidatorTest {
    @Test
    void 시도_횟수_입력되지_않은_경우_예외() {
        String input = null;
        assertThatThrownBy(() -> AttemptCountValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_정수가_아닌_경우_예외() {
        String input = "seok";
        assertThatThrownBy(() -> AttemptCountValidator.validateInteger(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_음의_정수인_경우_예외() {
        Integer attemptCount = -1;
        assertThatThrownBy(() -> AttemptCountValidator.validateNonNegative(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수_0_이상_정수_정상() {
        Integer attemptCount = 5;
        assertThatCode(() -> AttemptCountValidator.validateNonNegative(attemptCount))
                .doesNotThrowAnyException();
    }
}