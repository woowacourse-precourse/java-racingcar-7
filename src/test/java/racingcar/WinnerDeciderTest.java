package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class WinnerDeciderTest {
    private final WinnerDecider winnerDecider = new WinnerDecider();

    @Test
    void 우승자_결정_테스트() {
        List<Car> carList = List.of(
                new Car("pobi", 3),
                new Car("woni", 2),
                new Car("jun", 1)
        );
        Assertions.assertThat(winnerDecider.decideWinner(carList)).isEqualTo(List.of("pobi"));
    }

    @Test
    void 공동_우승자_결정_테스트() {
        List<Car> carList = List.of(
                new Car("pobi", 3),
                new Car("woni", 3),
                new Car("jun", 1)
        );
        Assertions.assertThat(winnerDecider.decideWinner(carList)).isEqualTo(List.of("pobi", "woni"));
    }
}