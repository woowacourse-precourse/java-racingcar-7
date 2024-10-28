package racingcar.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Race;

class RaceTest {
    private List<Car> cars;
    private Race race;

    @BeforeEach
    void 셋업() {
        cars = Arrays.asList(new Car("car1"), new Car("car2"), new Car("car3"));
        race = new Race(cars, 3);
    }

    @Test
    void 경주_시작후_자동차_이동() {
        race.start();

        for (Car car : cars) {
            assertThat(car.getPosition()).isNotEmpty();
        }
    }

    @Test
    void 승자_확인() {
        race.start();

        List<Car> winners = race.getWinner();

        int maxPositionLength = winners.get(0).getPosition().length();
        assertThat(winners).allMatch(car -> car.getPosition().length() == maxPositionLength);
    }
}
