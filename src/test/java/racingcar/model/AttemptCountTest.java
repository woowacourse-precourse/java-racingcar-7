package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class AttemptCountTest {

    @Test
    void 시도_횟수에_음수가_들어오면_예외를_반환한다() {
        assertThatThrownBy(() -> new AttemptCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}