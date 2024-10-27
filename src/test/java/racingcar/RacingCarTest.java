package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    void 자동차_이동횟수_증가() {
        RacingCar car = new RacingCar("car1");
        car.raiseMoveCount();

        assertThat(car.getMoveCount()).isEqualTo(1);
    }

    @Test
    void 자동차별_이동횟수_출력() {
        RacingCar car1 = new RacingCar("car1");
        RacingCar car2 = new RacingCar("car2");
        car1.raiseMoveCount();

        assertThat(car1.racingCarInfo()).isEqualTo("car1 : -");
        assertThat(car2.racingCarInfo()).isEqualTo("car2 : ");
    }
}
