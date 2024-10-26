package racingcar.model.race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.ReflectionUtil;
import racingcar.model.car.MyProgress;
import racingcar.model.position.Distance;
import racingcar.model.position.Position;

public class MyProgressTest {

    @Test
    @DisplayName("Lap 5개 모두 완주한 경우")
    void completeAllLap() {
        // given
        Lap lap = Lap.ZERO;
        Position position = Position.from("-----");
        MyProgress myProgress = MyProgress.from(lap);
        ReflectionUtil.forceSetField(myProgress, "position", position);
        // when
        boolean actual = myProgress.completedAllLap();
        // then
        assertThat(actual).isEqualTo(true);
    }

    @Test
    @DisplayName("Lap을 모두 완주하지 못한 경우")
    void failedToCompleteAllLap() {
        // given
        Lap remainingLap = Lap.from(1);
        MyProgress myProgress = MyProgress.from(remainingLap);
        // when
        boolean actual = myProgress.completedAllLap();
        // then
        assertThat(actual).isEqualTo(false);
    }

    @Test
    @DisplayName("총 5바퀴 중 3바뀌 남았을 때")
    void test() {
        // given
        Lap remainingLap = Lap.from(3);
        Position position = Position.from("---");
        MyProgress myProgress = MyProgress.from(remainingLap);
        ReflectionUtil.forceSetField(myProgress, "position", position);

        // when
        myProgress.updateRemainingLap();
        myProgress.updatePosition(Distance.ONE);

        // then
        assertThat(myProgress.toString()).isEqualTo("----");
    }
}
