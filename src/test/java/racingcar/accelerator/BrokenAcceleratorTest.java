package racingcar.accelerator;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.Car;

class BrokenAcceleratorTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final Accelerator accelerator = new BrokenAccelerator();

    @Test
    public void 전진_테스트() throws Exception {
        //Given
        int expected = 1;

        //When, Then
        assertRandomNumberInRangeTest(
                () -> {
                    int actual = accelerator.accelerate(Car.ACCELERATION_THRESHOLD);
                    Assertions.assertThat(actual).isEqualTo(expected);
                },
                MOVING_FORWARD
        );
    }

    @Test
    public void 정지_테스트() throws Exception {
        //Given
        int expected = 0;

        //When, Then
        assertRandomNumberInRangeTest(
                () -> {
                    int actual = accelerator.accelerate(Car.ACCELERATION_THRESHOLD);
                    Assertions.assertThat(actual).isEqualTo(expected);
                },
                STOP
        );
    }
}