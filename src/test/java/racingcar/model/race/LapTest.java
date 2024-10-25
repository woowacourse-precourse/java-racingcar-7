package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.common.constant.RaceConstant.DEFAULT_LAP_COUNTING_POLICY;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LapTest {

    @Test
    @DisplayName("남은 Lap 수 : 3 → 2")
    void test() {
        // given
        Lap remainingLap = Lap.from("3");
        // when
        remainingLap.minus(DEFAULT_LAP_COUNTING_POLICY);
        // then
        Lap expected = Lap.from("2");
        assertThat(remainingLap.equals(expected)).isTrue();
    }
}
