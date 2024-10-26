package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static racingcar.domain.ErrorMessage.ATTEMPT_RANGE;

import org.junit.jupiter.api.Test;

class AttemptCounterTest {


    @Test
    void 최솟값보다_작은_시도횟수_예외_처리() {
        assertThatThrownBy(() -> new AttemptCounter(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPT_RANGE.getMessage());
    }

    @Test
    void 최대값보다_큰_시도횟수_예외_처리() {
        assertThatThrownBy(() -> new AttemptCounter(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ATTEMPT_RANGE.getMessage());
    }

}