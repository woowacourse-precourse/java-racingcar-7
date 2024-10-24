package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class RaceManagerTest {
    private final RaceManager raceManager = new RaceManager();
    @Test
    void 우승자_찾기() {
        //given
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"), new Car("d"));

        cars.get(0).move();
        cars.get(0).move();
        cars.get(0).move();
        cars.get(1).move();
        cars.get(1).move();
        cars.get(2).move();
        cars.get(2).move();
        cars.get(3).move();
        cars.get(3).move();
        cars.get(3).move();

        //when
        List<Car> winners = raceManager.getWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("a");
        assertThat(winners.get(1).getName()).isEqualTo("d");

    }

    @Test
    void 경주_시작() {
        //given
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"), new Car("d"));

        //when
        String result = raceManager.race(cars);

        //then
        assertThat(cars.get(0).getLocation()).isIn(0, 1);
        assertThat(cars.get(1).getLocation()).isIn(0, 1);
        assertThat(cars.get(2).getLocation()).isIn(0, 1);
        assertThat(cars.get(3).getLocation()).isIn(0, 1);

    }

}