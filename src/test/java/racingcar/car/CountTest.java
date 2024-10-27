package racingcar.car;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CountTest {

    @DisplayName("경기 횟수는 1번 이상, 1,000번 이하의 범위에서만 가능하다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1000})
    void newCountWithOutOfRange(int count) {
        Assertions.assertThatThrownBy(() -> new Count(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("경기 횟수는 최소 1번 이상, 최대 1,000번까지만 가능합니다.");
    }
}