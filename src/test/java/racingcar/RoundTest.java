package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.CompeteCars;
import racingcar.game.Round;


class RoundTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void moveCountOutRangeTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));

        assertThatThrownBy(() -> new Round(81, cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void hasNextTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(1, cars);

        round.progress();

        assertThat(round.hasNext()).isFalse();
    }

    @Test
    void progressTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(1, cars);

        assertRandomNumberInRangeTest(() -> {
            round.progress();
            assertThat(cars.getWinnerCars()).contains("test");
        }, MOVING_FORWARD, STOP);
    }
}