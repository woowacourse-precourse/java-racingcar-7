package racingcar.server.model.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.model.car.MyProgress;
import racingcar.app.server.model.location.Distance;
import racingcar.app.server.model.location.Position;
import racingcar.app.server.model.race.Lap;
import racingcar.server.helper.MyProgressHelper;

public class MyProgressTest {

    @Test
    @DisplayName("Lap 5개 모두 완주한 경우")
    void completeAllLap() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(0, 5);

        // when
        boolean actual = myProgress.completedAllLap();

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Lap을 모두 완주하지 못한 경우")
    void failedToCompleteAllLap() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(1, 3);

        // when
        boolean actual = myProgress.completedAllLap();

        // then
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("총 5바퀴 중 3바뀌 남았을 때")
    void test() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(3, 3);

        // when
        myProgress.countDownRemainingLap(Lap.ONE);
        myProgress.updateDistance(Distance.ONE);

        // then
        Position actual = myProgress.currentPosition();
        Position expected = Position.from("----");
        assertThat(actual.equals(expected)).isTrue();
    }
}
