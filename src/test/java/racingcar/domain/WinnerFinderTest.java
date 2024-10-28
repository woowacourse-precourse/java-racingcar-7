package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerFinderTest {

    @Test
    void 단독_우승자_계산_테스트() {
        // given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        // when
        cars.get(0).tryToMove(5);
        // then
        String winners = WinnerFinder.calculateWinners(cars);
        assertThat(winners).isEqualTo("pobi");
    }

    @Test
    void 공동_우승자_계산_테스트() {
        // given
        List<Car> cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("jun")
        );
        // when
        cars.get(0).tryToMove(5);
        cars.get(2).tryToMove(5);
        // then
        String winners = WinnerFinder.calculateWinners(cars);
        assertThat(winners).isEqualTo("pobi, jun");
    }
}
