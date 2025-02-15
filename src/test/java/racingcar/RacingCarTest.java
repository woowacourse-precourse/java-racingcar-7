package racingcar;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest  {
    @Test
    void 앞으로_전진하는_경우_테스트(){
        Assertions.assertRandomNumberInRangeTest(() -> {
            RacingCar car = new RacingCar("test");
            car.moveForward();
            assertThat(car.getMoveCount()).isEqualTo(1);
        }, 5);
    }

    @Test
    void 앞으로_전진하지_못하는_경우_테스트(){
        Assertions.assertRandomNumberInRangeTest(() -> {
            RacingCar car = new RacingCar("test");
            car.moveForward();
            assertThat(car.getMoveCount()).isEqualTo(0);
        }, 3);
    }
}
