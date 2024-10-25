package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.config.AppConfig;
import racingcar.helper.ReflectionUtil;
import racingcar.model.race.Lap;
import racingcar.model.race.Position;

public class CarTest {

    @AfterEach
    void resetProfile() {
        AppConfig.resetProfile();
    }

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
    @DisplayName("내 현황 수정")
    void test() {
        // given
        AppConfig.setTestProfileWithValue("4");
        Lap remainLap = Lap.from("3");
        Position position = Position.initiate();
        ReflectionUtil.forceSetField(position, "value", "---");
        MyProgress myProgress = MyProgress.from(remainLap, position);
        Car sut = Car.from("user1", myProgress);
        // when
        sut.updateProgress();
        // then
        assertThat(position.toString()).isEqualTo("----");
        assertThat(remainLap).isEqualTo(Lap.from("2"));
    }
}
