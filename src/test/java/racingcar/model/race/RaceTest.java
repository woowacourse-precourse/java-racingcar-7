package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.common.message.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;
import static racingcar.model.race.Lap.ZERO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.race.exception.ShouldNotBeMinusException;

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

        // when
        race.moveToNextLap();

        // then
        assertThat(race.isUnderway()).isTrue();
    }

    @Test
    @DisplayName("[ShouldNotBeMinusException] 끝났는데 다음 Lap으로 넘어가려는 경우")
    void noAvailableLapRemain() {
        // given
        Lap remainingCount = ZERO;
        Race race = Race.from(remainingCount);

        // when & then
        assertThatThrownBy(race::moveToNextLap)
                .isInstanceOf(ShouldNotBeMinusException.class)
                .hasMessage(LAP_COUNT_SHOULD_NOT_BE_MINUS);
    }
}
