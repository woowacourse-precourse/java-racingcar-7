package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.BrokenAccelerator;

class CarGroupTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 가장_멀리_전진한_자동차_테스트() throws Exception {

        // Given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("pobi"), new Car("woni")));
        assertRandomNumberInRangeTest(
                () -> {
                    carGroup.accelerateAll(new BrokenAccelerator());
                },
                MOVING_FORWARD, STOP
        );
        int expected = 1;

        // When
        int actual = carGroup.getLongestMileageCars().size();

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 가장_멀리_전진한_여러_자동차_테스트() throws Exception {

        // Given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("pobi"), new Car("woni")));
        assertRandomNumberInRangeTest(
                () -> {
                    carGroup.accelerateAll(new BrokenAccelerator());
                },
                MOVING_FORWARD, MOVING_FORWARD
        );

        int expected = 2;

        // When
        int actual = carGroup.getLongestMileageCars().size();

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}