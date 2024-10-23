package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AttemptTest {
    @Test
    @DisplayName("시도 횟수가 숫자가 아니면 예외 발생")
    void notDigitAttemptException() {
        String attemptCount = "a";

        assertThatThrownBy(() -> new Attempt(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 음수일 경우 예외 발생")
    void negativeAttemptException() {
        String attemptCount = "-1";

        assertThatThrownBy(() -> new Attempt(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도 횟수가 0일 경우 예외 발생")
    void zeroAttemptException() {
        String attemptCount = "0";

        assertThatThrownBy(() -> new Attempt(attemptCount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
