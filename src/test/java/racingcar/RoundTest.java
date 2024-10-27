package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;


class RoundTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void moveCountOutRangeTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));

        assertThatThrownBy(() -> new Round(81, cars)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getMoveCountTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(5, cars);

        assertThat(round.getMoveCount()).isEqualTo(5);
    }

    @Test
    void progressTest() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(1, cars);

        assertRandomNumberInRangeTest(() -> {
            round.progress();
            List<Integer> movedPositions = cars.getAll().stream().map(Car::getPosition).toList();
            assertThat(movedPositions).containsExactly(1, 1);
        }, MOVING_FORWARD, MOVING_FORWARD);
    }

    @Test
    void getResult() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(1, cars);

        assertRandomNumberInRangeTest(() -> {
            round.progress();
            assertThat(round.getResult()).isEqualTo("test : -\ncars : ");
        }, MOVING_FORWARD, STOP);
    }

    @Test
    void getWinners() {
        CompeteCars cars = new CompeteCars(List.of("test", "cars"));
        Round round = new Round(1, cars);

        assertRandomNumberInRangeTest(() -> {
            round.progress();
            assertThat(round.getWinners()).containsExactly("test");
        }, MOVING_FORWARD, STOP);
    }
}