package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class TryCountTest {

    @Test
    void 시도_횟수가_1미만인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> TryCount.of("0"))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("시도 횟수는 1이상이어야 합니다.");
    }

    @Test
    void 시도_횟수가_숫자가_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> TryCount.of("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자여야 합니다.");
    }
}
