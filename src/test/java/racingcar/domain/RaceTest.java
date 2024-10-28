package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceTest {
    @DisplayName("레이스 실행 후 모든 자동차의 위치는 0과 실행 횟수 사이다")
    @Test
    void carPositionsAfterRace() {
        List<Car> cars = Arrays.asList(new Car("car1"), new Car("car2"));
        Race race = new Race(cars);
        int tryCount = 5;

        race.run(tryCount);

        cars.forEach(car ->
                assertThat(car.getPosition()).isBetween(0, tryCount)
        );
    }

    @DisplayName("단독 우승자가 있는 경우 해당 우승자만 반환한다")
    @Test
    void singleWinner() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(4); // position 1
        Race race = new Race(Arrays.asList(car1, car2));

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("car1");
    }

    @DisplayName("동일한 위치의 자동차들이 있으면 공동 우승으로 처리한다")
    @Test
    void multipleWinners() {
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        car1.move(4); // position 1
        car2.move(4); // position 1
        Race race = new Race(Arrays.asList(car1, car2));

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactlyInAnyOrder("car1", "car2");
    }

}
