package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

class RacingCarTest {

    @Test
    void 전진한다() {
        RacingCar racingCar = new RacingCar("테스트차");
        racingCar.race();
        assertThat(racingCar.getDistance()).isEqualTo("-");
    }
}