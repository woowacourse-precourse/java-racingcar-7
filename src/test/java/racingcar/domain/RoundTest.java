package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class RoundTest {

    @Test
    void 라운드_수가_0이하일_경우_예외_발생() {
        assertThatThrownBy(() -> new Round(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1에서 20 사이여야 합니다.");
    }

    @Test
    void 라운드_수가_최대_범위를_초과할_경우_예외_발생() {
        assertThatThrownBy(() -> new Round(21))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1에서 20 사이여야 합니다.");
    }
}
