package racingcar.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptCountValidatorTest {

    @Test
    @DisplayName("시도 횟수가 음수인 경우 IllegalArgumentExection을 발생시킨다.")
    void validateAttemptCount_Exception() {
        // given
        int input = -1;

        String expectedMessage = "시도 횟수는 양수여야 합니다.";

        // when, then
        assertThatThrownBy(() -> AttemptCountValidator.validateAttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

    }
}
