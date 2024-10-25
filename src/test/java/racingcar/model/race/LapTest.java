package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.race.exception.ShouldNotBeMinusException;

public class LapTest {

    @Test
    @DisplayName("남은 Lap 수 : 3 → 2")
    void checkRemainingLap() {
        // given
        Lap remainingLap = Lap.from("3");
        // when
        remainingLap.minus(DEFAULT_LAP_COUNTING_POLICY);
        // then
        Lap expected = Lap.from("2");
        assertThat(remainingLap.equals(expected)).isTrue();
    }

    @Test
    @DisplayName("0 빼기 음수")
    void zeroMinusNegative() {
        // given
        Lap remainingLap = Lap.from("1");

        // when & then
        assertThatThrownBy(() -> remainingLap.minus("-1"))
                .isInstanceOf(ShouldNotBeMinusException.class);
    }

    @Test
    @DisplayName("뺏을 때 음수가 되는 경우")
    void negativeResultWhenOperateMinus() {
        // given
        Lap remainingLap = Lap.from("0");

        // when & then
        assertThatThrownBy(() -> remainingLap.minus("-1"))
                .isInstanceOf(ShouldNotBeMinusException.class);
    }
}
