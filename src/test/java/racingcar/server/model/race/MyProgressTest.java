package racingcar.server.model.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.server.helper.MyProgressHelper;
import racingcar.server.model.car.MyProgress;
import racingcar.server.model.position.Distance;

public class MyProgressTest {

    @Test
    @DisplayName("Lap 5개 모두 완주한 경우")
    void completeAllLap() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(0, "-----");

        // when
        boolean actual = myProgress.completedAllLap();

        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Lap을 모두 완주하지 못한 경우")
    void failedToCompleteAllLap() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(1, "---");

        // when
        boolean actual = myProgress.completedAllLap();

        // then
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("총 5바퀴 중 3바뀌 남았을 때")
    void test() {
        // given
        MyProgress myProgress = MyProgressHelper.mock(3, "---");

        // when
        myProgress.countDownRemainingLap(Lap.ONE);
        myProgress.updatePosition(Distance.ONE);

        // then
        assertThat(myProgress.toString()).isEqualTo("----");
    }
}
