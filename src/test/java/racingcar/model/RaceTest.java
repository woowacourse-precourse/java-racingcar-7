package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceTest {
    private List<Car> cars;
    private Race race;

    @BeforeEach
    public void setUp() {
        cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        race = new Race(cars, 5);
    }

    @Test
    void 거리_0_이상() {
        race.startEachRound(cars);
        for (Car car : cars) {
            assertThat(car.getDistance()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    void 단독_우승() {
        cars.get(0).setDistance(3);
        cars.get(1).setDistance(5);
        List<String> winners = race.getWinners(cars);
        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners).contains("car2");
    }

    @Test
    void 공동_우승() {
        cars.get(0).setDistance(5);
        cars.get(1).setDistance(5);
        List<String> winners = race.getWinners(cars);
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners).contains("car1", "car2");
    }

}