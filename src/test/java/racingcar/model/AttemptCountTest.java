package racingcar.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AttemptCountTest {

    @ParameterizedTest
    @ValueSource(strings = {"0", "-10"})
    void 시도횟수_초기값이_0_이하일_경우_예외테스트(int value) {
        assertThatThrownBy(() -> AttemptCount.from(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
