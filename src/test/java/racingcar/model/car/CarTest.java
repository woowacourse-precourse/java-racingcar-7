package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.ReflectionUtil;
import racingcar.model.race.Distance;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class CarTest {

    @Test
    @DisplayName("중간 진행 사항 확인")
    void checkLapChart() {
        // given
        Lap remainLap = Lap.from("6");
        Position position = Position.initiate();
        ReflectionUtil.forceSetField(position, "value", "---");
        MyProgress myProgress = MyProgress.from(remainLap, position);
        Car sut = Car.from("user1", myProgress);

        // when
        String actual = sut.myProgressSummary();

        // then
        assertThat(actual).isEqualTo("user1 : ---");
    }

    @Test
    @DisplayName("movement value가 1일 때 내 현황 수정할 수 있다.")
    void updateMyProgress() {
        // given
        Lap remainLap = Lap.from("3");
        Position position = Position.initiate();
        ReflectionUtil.forceSetField(position, "value", "---");
        MyProgress myProgress = MyProgress.from(remainLap, position);
        Car sut = Car.from("user1", myProgress);
        // when
        sut.updateProgress(Distance.ONE);
        // then
        assertThat(position.toString()).isEqualTo("----");
        Lap expectedRemainingLap = Lap.from("2");
        assertThat(remainLap.equals(expectedRemainingLap)).isTrue();
    }

    @Test
    @DisplayName("movement value가 0일 때 내 현황 수정할 수 없음.")
    void canNotUpdateMyProgress() {
        // given
        Lap remainLap = Lap.from("3");
        Position position = Position.initiate();
        ReflectionUtil.forceSetField(position, "value", "---");
        MyProgress myProgress = MyProgress.from(remainLap, position);
        Car sut = Car.from("user1", myProgress);

        // when
        sut.updateProgress(Distance.ZERO);

        // then
        assertThat(position.toString()).isEqualTo("---");
        Lap expectedRemainingLap = Lap.from("3");
        assertThat(remainLap.equals(expectedRemainingLap)).isTrue();

    }
}
