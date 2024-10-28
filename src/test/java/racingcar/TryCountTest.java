package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.Race.TryCount;

public class TryCountTest {
    @DisplayName("입력 받은 시도 횟수가 숫자가 아닌 경우 예외가 발생한다")
    @Test
    void 시도_횟수_숫자_테스트() {
        assertThatThrownBy(() -> TryCount.from("하나")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력 받은 시도 횟수가 빈 값인 경우 예외가 발생한다")
    @Test
    void 시도_횟수_빈_값_테스트() {
        assertThatThrownBy(() -> TryCount.from("")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수가 1~10 범위를 벗어나는 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"0","11"})
    void 시도_횟수_범위_테스트(String count) {
        assertThatThrownBy(() -> TryCount.from(count)).isInstanceOf(IllegalArgumentException.class);
    }
}
