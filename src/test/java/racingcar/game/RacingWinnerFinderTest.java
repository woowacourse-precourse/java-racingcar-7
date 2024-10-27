package racingcar.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingWinnerFinderTest {

    private final RacingWinnerFinder winnerFinder = new RacingWinnerFinder();

    @Test
    @DisplayName("가장 앞에 있는 우승자를 찾음")
    void test1() {
        Car winner = new Car("winner", 5);
        List<Car> cars = List.of(
                winner,
                new Car("losser", 1),
                new Car("losser", 3)
        );

        List<Car> result = winnerFinder.find(cars);

        assertThat(result).containsExactlyInAnyOrder(winner);
    }

    @Test
    @DisplayName("여러 우승자를 찾음")
    void test2() {
        Car winner1 = new Car("winner", 5);
        Car winner2 = new Car("winner", 5);
        List<Car> cars = List.of(
                new Car("losser", 1),
                new Car("losser", 3),
                winner1, winner2
        );

        List<Car> result = winnerFinder.find(cars);

        assertThat(result).containsExactlyInAnyOrder(winner1, winner2);
    }
}