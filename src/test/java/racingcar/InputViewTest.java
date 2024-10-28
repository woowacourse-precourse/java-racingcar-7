package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class InputViewTest {
    @Test
    void 시도_횟수_유효성_검증_테스트() {
        int result = InputView.parseAttempts("5");
        assertThat(result).isEqualTo(5);

        assertThatThrownBy(() -> InputView.parseAttempts("five"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 숫자로 입력해야 합니다.");
    }
}