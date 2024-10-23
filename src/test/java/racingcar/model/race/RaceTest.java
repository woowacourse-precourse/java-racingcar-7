package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.message.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;
import static racingcar.model.race.Lap.ZERO;

import java.math.BigInteger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.race.exception.ShouldNotBeMinusException;

public class RaceTest {

    @Test
    @DisplayName("레이스 : 현재 진행중")
    void raceIsUnderway() {
        // given
        BigInteger value = BigInteger.valueOf(3);
        Lap remainingCount = Lap.of(value);
        Race race = Race.of(remainingCount);
        // when
        boolean actual = race.isUnderway();
        // then
        assertThat(actual).isTrue();
    }

    @Test
    @DisplayName("레이스 : 종료")
    void raceFinished() {
        // given
        Lap remainingCount = ZERO;
        Race race = Race.of(remainingCount);

        // when
        boolean actual = race.isUnderway();

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("다음 Lap으로 이동")
    void test() {
        // given
        BigInteger value = BigInteger.valueOf(3);
        Lap remainingCount = Lap.of(value);
        Race race = Race.of(remainingCount);

        // when
        race.moveToNextLap();

        // then
        BigInteger expected = BigInteger.valueOf(2);
        assertThat(remainingCount.equals(Lap.of(expected))).isTrue();
    }

    @Test
    @DisplayName("[ShouldNotBeMinusException] 끝났는데 다음 Lap으로 넘어가려는 경우")
    void noAvailableLapRemain() {
        // given
        BigInteger value = BigInteger.valueOf(0);
        Lap remainingCount = Lap.of(value);
        Race race = Race.of(remainingCount);

        // when & then
        assertThatThrownBy(race::moveToNextLap)
                .isInstanceOf(ShouldNotBeMinusException.class)
                .hasMessage(LAP_COUNT_SHOULD_NOT_BE_MINUS);
    }
}
