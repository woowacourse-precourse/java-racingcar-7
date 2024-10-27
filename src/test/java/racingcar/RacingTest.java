package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class RacingTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    Racing racing = new Racing();

    @Test
    void 자동차_이동() {
        Car testCar1 = new Car("test1");

        assertRandomNumberInRangeTest(
            () -> {
                racing.moveCar(testCar1);
                assertThat(testCar1.getMoveCount()).isEqualTo(1);
            },
            MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 자동차_여러대_이동() {
        Car testCar1 = new Car("test1");
        Car testCar2 = new Car("test2");
        Car testCar3 = new Car("test3");
        List<Car> testCars = List.of(testCar1, testCar2, testCar3);

        assertRandomNumberInRangeTest(
            () -> {
                racing.moveCars(testCars);
                assertThat(testCar1.getMoveCount()).isEqualTo(1);
                assertThat(testCar2.getMoveCount()).isEqualTo(1);
                assertThat(testCar3.getMoveCount()).isEqualTo(0);
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

}