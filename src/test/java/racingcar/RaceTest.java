package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {

    @Test
    @DisplayName("attempts가 0일 때 자동차의 위치가 초기값(0)으로 유지")
    void raceWithZeroAttempts_ShouldKeepCarsAtStartingPosition() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        Race race = new Race(cars, 0);
        List<Car> winners = race.start();

        // 시도 횟수 0이므로 자동차의 위치가 초기값이어야 합니다.
        assertThat(cars.get(0).getPosition()).isEqualTo(0);
        assertThat(cars.get(1).getPosition()).isEqualTo(0);

        // 시도 횟수 0일 때 모든 자동차가 공동 우승자가 됩니다.
        assertThat(winners).containsExactlyInAnyOrder(cars.get(0), cars.get(1));
    }

    @Test
    @DisplayName("attempts가 1일 때 자동차가 움직인다")
    void raceWithOneAttempt_ShouldMoveCarsAccordingly() {
        List<Car> cars = List.of(new Car("pobi"), new Car("woni"));
        Race race = new Race(cars, 1);
        List<Car> winners = race.start();

        assertThat(winners).isNotEmpty();
        assertThat(cars.stream().anyMatch(car -> car.getPosition() > 0)).isTrue();
    }
}