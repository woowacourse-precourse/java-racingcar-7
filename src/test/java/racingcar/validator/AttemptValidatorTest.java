package racingcar.validator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.config.GameErrorMessage.NEGATIVE_ATTEMPT_MESSAGE;
import static racingcar.config.GameErrorMessage.NON_NUMERIC_MESSAGE;
import static racingcar.validator.AttemptValidator.validateAttempt;

import org.junit.jupiter.api.Test;

class AttemptValidatorTest {
    @Test
    void 정수가_아닌_수_검증() {
        String testString = "a";

        assertThatThrownBy(() -> validateAttempt(testString))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_NUMERIC_MESSAGE);
    }

    @Test
    void Zero_이하의_정수_입력() {
        String testString = "0";

        assertThatThrownBy(() -> validateAttempt(testString))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_ATTEMPT_MESSAGE);
    }
}