package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialCountTest {

    @Test
    void trialCountTest() {
        assertThatThrownBy(() -> {
            Application.getTrialCount("abc");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다.");

        assertThatThrownBy(() -> {
            Application.getTrialCount("!*#&$");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("유효한 숫자를 입력해야 합니다.");

        assertThatThrownBy(() -> {
            Application.getTrialCount(null);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수가 입력되지 않았습니다.");
    }
}