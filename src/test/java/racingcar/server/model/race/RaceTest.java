package racingcar.server.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.app.server.error.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;
import static racingcar.app.server.model.race.Lap.ZERO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.exception.ShouldNotBeMinusException;
import racingcar.app.server.model.race.Lap;
import racingcar.app.server.model.race.Race;

public class RaceTest {

    @Test
    @DisplayName("레이스 : 현재 진행중")
    void raceIsUnderway() {
        // given
        Lap remainingCount = Lap.from(3);
        Race race = Race.from(remainingCount);
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
        Race race = Race.from(remainingCount);

        // when
        boolean actual = race.isUnderway();

        // then
        assertThat(actual).isFalse();
    }

    @Test
    @DisplayName("다음 Lap으로 이동")
    void test() {
        // given
        Lap remainingCount = Lap.from(3);
        Race race = Race.from(remainingCount);
        Lap countDown = Lap.ONE;

        // when
        race.countDownRemainingLapCount(countDown);

        // then
        assertThat(race.isUnderway()).isTrue();
    }

    @Test
    @DisplayName("[ShouldNotBeMinusException] 끝났는데 다음 Lap으로 넘어가려는 경우")
    void noAvailableLapRemain() {
        // given
        Lap remainingCount = ZERO;
        Race race = Race.from(remainingCount);
        Lap countDown = Lap.ONE;
        // when & then
        assertThatThrownBy(() -> race.countDownRemainingLapCount(countDown))
                .isInstanceOf(ShouldNotBeMinusException.class)
                .hasMessage(LAP_COUNT_SHOULD_NOT_BE_MINUS);
    }

    @Test
    @DisplayName("동등성 비교")
    void testEquality() {
        // given
        Lap remainingCount = Lap.from(3L);
        Race race = Race.from(remainingCount);
        Race oRace = Race.from(remainingCount);

        // when
        boolean equals = race.equals(oRace);

        // then
        assertThat(equals).isTrue();
    }
}
