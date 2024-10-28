package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RoundCountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void validateTest_whenCountIsNotPositive_throwException(int count) {
        assertThatThrownBy(() -> new RoundCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 양수이어야 합니다");
    }
}
