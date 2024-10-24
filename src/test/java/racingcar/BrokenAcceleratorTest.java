package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.Accelerator;
import racingcar.accelerator.BrokenAccelerator;

class BrokenAcceleratorTest {

    private final Accelerator accelerator = new BrokenAccelerator();

    @Test
    public void 전진_테스트() throws Exception {
        //Given
        int testThreshold = 0;
        int expected = 1;

        //When
        int actual = accelerator.accelerate(testThreshold);

        //When, Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 정지_테스트() throws Exception {
        //Given
        int testThreshold = 9;
        int expected = 0;

        //When
        int actual = accelerator.accelerate(testThreshold);

        //When, Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}