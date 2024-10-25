package racingcar.model.winner;

import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnersTest {

    @Test
    void 우승자_판별_테스트() {
        Cars cars = new Cars("phobi,strag,seoun");
        cars.moves(() -> {return 5;});
        Winners winners = new Winners(cars);

        assertThat(winners.getRacingGameWinners()).isEqualTo(List.of("phobi", "strag", "seoun"));
    }


}
