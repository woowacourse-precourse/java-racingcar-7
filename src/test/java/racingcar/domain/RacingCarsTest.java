package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {
    @Test
    void 자동차를_생성한다() {
        // given
        List<String> carNames = Arrays.asList("jang", "jin", "young");

        // when
        RacingCars racingCars = new RacingCars(carNames);

        // then
        assertThat(racingCars.getCarsSize()).isEqualTo(3);
        assertThat(racingCars.getCarNames().get(0)).isEqualTo("jang");
    }

    @Test
    void 자동차들을_이동시킨다() {
        // given
        List<String> carNames = Arrays.asList("jang", "jin", "young");
        RacingCars racingCars = new RacingCars(carNames);

        // when
        racingCars.moveCars(Arrays.asList(5, 1, 5));

        // then
        assertThat(racingCars.getCarPositions().get(0)).isEqualTo(1);
        assertThat(racingCars.getCarPositions().get(1)).isEqualTo(0);
        assertThat(racingCars.getCarPositions().get(2)).isEqualTo(1);
    }

    @Test
    void 가장_많이_이동한_자동차를_뽑는다() {
        // given
        List<String> carNames = Arrays.asList("jang", "jin", "young");
        RacingCars racingCars = new RacingCars(carNames);
        racingCars.moveCars(Arrays.asList(5, 1, 5));

        // when
        List<String> winnerNames = racingCars.findWinners();

        // then
        assertThat(winnerNames.size()).isEqualTo(2);
        assertThat(winnerNames.get(1)).isEqualTo("young");
    }
}