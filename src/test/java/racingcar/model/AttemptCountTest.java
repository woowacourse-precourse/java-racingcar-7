package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AttemptCountTest {

    @Test
    void 음수가_들어오면_예외를_반환한다() {
        assertThatThrownBy(() -> new AttemptCount("-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "abc", "!", "123abc", "-5"})
    void 숫자가_아닌_문자가_들어오면_예외를_반환한다(String input) {
        assertThatThrownBy(() -> new AttemptCount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}