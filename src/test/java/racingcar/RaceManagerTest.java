package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RaceServiceTest {
    private final RaceService raceService = new RaceService();
    @Test
    void 우승자_찾기() {
        //given
        List<Car> cars = List.of(new Car("a"), new Car("b"), new Car("c"), new Car("d"));

        cars.get(0).move(4);
        cars.get(0).move(5);
        cars.get(0).move(6);
        cars.get(1).move(7);
        cars.get(1).move(8);
        cars.get(2).move(9);
        cars.get(2).move(4);
        cars.get(3).move(5);
        cars.get(3).move(6);
        cars.get(3).move(7);

        //when
        List<Car> winners = raceService.getWinners(cars);

        //then
        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("a");
        assertThat(winners.get(1).getName()).isEqualTo("d");

    }

}