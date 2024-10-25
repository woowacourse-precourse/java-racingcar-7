package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceCarTest {

    @Test
    void 자동차_이동_테스트(){
        RaceCar raceCar = new RaceCar("raceCar");
        raceCar.move();

        Assertions.assertThat(raceCar.getPosition()).isEqualTo(1);
    }
}
