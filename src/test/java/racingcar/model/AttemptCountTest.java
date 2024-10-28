package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AttemptCountTest {

    @DisplayName("시도 횟수를 생성할 수 있다.")
    @CsvSource({"1", "500"})
    @ParameterizedTest
    void createWithValidCount(int count) {
        // when & then
        AttemptCount attemptCount = new AttemptCount(count);

        // then
        assertThat(attemptCount).extracting("count")
                .isEqualTo(count);
    }

    @DisplayName("유효하지 않은 범위의 시도 횟수를 생성하면 예외가 발생한다.")
    @CsvSource({"-1", "0", "501"})
    @ParameterizedTest
    void createWithOutOfRangeCount(int count) {
        // when & then
        assertThatThrownBy(() -> new AttemptCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 1~500사이여야 합니다.");
    }

    @DisplayName("시도 횟수가 남아있지 않을 때 차감하려 하면 예외가 발생한다.")
    @Test
    void decreaseWhenRemainZeroCount() {
        //given
        int count = 1;
        AttemptCount attemptCount = new AttemptCount(count);
        attemptCount.decrease();

        // when & then
        assertThatThrownBy(attemptCount::decrease)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수가 남아있지 않습니다.");
    }

}
