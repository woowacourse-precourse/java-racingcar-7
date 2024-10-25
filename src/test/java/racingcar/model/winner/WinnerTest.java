package racingcar.model.winner;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnerTest {

    @Test
    void 우승자_판별_테스트() {
        Cars cars = new Cars("phobi", "strag", "seoun");
        cars.repeatMove(5, () -> {
            return 5;
        });
        Winner winner = new Winner(cars);

        assertThat(winner.getWinnerNames()).isEqualTo(List.of("phobi", "strag", "seou"));

    }
}
