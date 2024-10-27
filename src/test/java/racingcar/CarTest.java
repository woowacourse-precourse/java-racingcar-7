package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * CarTest
 */
public class CarTest {

    private final static int MOVE = 9;
    private final static int STOP = 0;

    @Test
    void car_move() {
        Car car = new Car("pobi");

        assertRandomNumberInRangeTest(() -> {
            car.moveOrStop();
        }, MOVE);

        Assertions.assertThat(car.getProgress()).isEqualTo(1);
    }

    @Test
    void car_stop() {
        Car car = new Car("pobi");

        assertRandomNumberInRangeTest(() -> {
            car.moveOrStop();
        }, STOP);

        Assertions.assertThat(car.getProgress()).isEqualTo(0);
    }

    @Test
    void name_longer_than_5_not_accepted() {
        String name = "benlty";

        Throwable throwable = catchThrowable(() -> new Car(name));

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

}
