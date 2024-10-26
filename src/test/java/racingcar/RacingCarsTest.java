package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class RacingCarsTest {

    @Test
    void 우승자를_찾는다() {
        // given
        RacingCar pobi = new RacingCar(new CarName("pobi"), 1);
        RacingCar crong = new RacingCar(new CarName("crong"), 3);
        RacingCar honux = new RacingCar(new CarName("honux"), 3);
        RacingCars racingCars = new RacingCars(List.of(pobi, crong, honux));

        // when
        List<String> winners = racingCars.findWinners();

        // then
        assertThat(winners).containsExactly("crong", "honux");
    }
}
