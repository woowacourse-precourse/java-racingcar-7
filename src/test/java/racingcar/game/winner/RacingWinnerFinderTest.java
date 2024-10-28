package racingcar.game.winner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.game.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingWinnerFinderTest {

    private final RacingWinnerFinder winnerFinder = new RacingWinnerFinder();

    @Test
    @DisplayName("가장 앞에 있는 우승자 이름을 찾음")
    void test1() {
        String winnerName = "winner";
        List<Car> cars = List.of(
                new Car(winnerName, 5),
                new Car("losser", 1),
                new Car("losser", 3)
        );

        Winner result = winnerFinder.find(cars);

        assertThat(result.getNames()).containsExactlyInAnyOrder(winnerName);
    }

    @Test
    @DisplayName("여러 우승자를 찾음")
    void test2() {
        String winnerName1 = "winner1";
        String winnerName2 = "winner2";
        List<Car> cars = List.of(
                new Car("losser", 1),
                new Car("losser", 3),
                new Car(winnerName1, 5),
                new Car(winnerName2, 5)
        );

        Winner result = winnerFinder.find(cars);

        assertThat(result.getNames()).containsExactlyInAnyOrder(winnerName1, winnerName2);
    }
}