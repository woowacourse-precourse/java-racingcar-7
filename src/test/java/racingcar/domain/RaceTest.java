package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.FixedRandomGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceTest {

    @Test
    @DisplayName("startRace 메서드가 Race 결과를 올바르게 업데이트하는지 확인")
    void startRace_CorrectResults() {
        // given
        Car car1 = new Car("car1", new FixedRandomGenerator(4));
        Car car2 = new Car("car2", new FixedRandomGenerator(3));
        Race race = new Race(List.of(car1, car2), 3);

        // when
        race.startRace();

        // then
        assertThat(car1.getDistance()).isGreaterThan(0);
        assertThat(car2.getDistance()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("getWinners 메서드가 최대 거리의 우승자를 반환하는지 확인")
    void getWinners_WhenMaxDistance_ReturnsWinners() {
        // given
        Car car1 = new Car("car1", new FixedRandomGenerator(4));
        Car car2 = new Car("car2", new FixedRandomGenerator(3));
        car1.move();
        Race race = new Race(List.of(car1, car2), 1);

        // when
        List<String> winners = race.getWinners();

        // then
        assertThat(winners).containsExactly("car1");
    }
}
