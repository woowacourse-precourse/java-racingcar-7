package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.request.TrialCountRequest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TrialCountTest {

    @DisplayName("시도 횟수가 1번 미만이거나 10번 초과면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 11, 100})
    void throwsExceptionWhenLengthIsOutOfRange(int count) {
        assertThatThrownBy(() -> new TrialCount(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 1번, 최대 10번까지 시도 가능합니다.");
    }

    @DisplayName("시도 횟수가 남았을 때 진행 상태는 true이어야 한다.")
    @Test
    void returnsTrueWhenCountIsGreaterThanZero() {
        //given
        TrialCount trialCount = new TrialCount(2);
        //when
        trialCount.minusCount();
        boolean progress = trialCount.isProgress();
        //then
        assertThat(progress).isTrue();
    }

    @DisplayName("시도 횟수가 남지 않았다면 진행 상태는 false이어야 한다.")
    @Test
    void returnsFalseWhenCountIsZero() {
        //given
        TrialCount trialCount = new TrialCount(1);
        //when
        trialCount.minusCount();
        boolean progress = trialCount.isProgress();
        //then
        assertThat(progress).isFalse();
    }

    @DisplayName("시도 횟수가 숫자형식이 아니라면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "아", "o"})
    void throwsExceptionWhenIsNotNumber(String count) {
        assertThatThrownBy(() -> new TrialCountRequest(count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 입력하실 수 있습니다.");
    }
}