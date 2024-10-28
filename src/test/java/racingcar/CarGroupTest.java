package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.CarTest.createTestCar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarGroupTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 자동차_주행정보_출력_테스트() throws Exception {
        //Given
        CarGroup carGroup = new CarGroup(List.of(createTestCar("pobi"), createTestCar("woni")));
        assertRandomNumberInRangeTest(
                carGroup::accelerateAll,
                MOVING_FORWARD, STOP
        );
        String expected = "pobi : -\nwoni : ";

        //When
        String actual = carGroup.getDrivingRecords();
        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 가장_멀리_전진한_자동차_테스트() throws Exception {

        // Given
        CarGroup carGroup = new CarGroup(List.of(createTestCar("pobi"), createTestCar("woni")));
        assertRandomNumberInRangeTest(
                carGroup::accelerateAll,
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
        CarGroup carGroup = new CarGroup(List.of(createTestCar("pobi"), createTestCar("woni")));
        assertRandomNumberInRangeTest(
                carGroup::accelerateAll,
                MOVING_FORWARD, MOVING_FORWARD
        );

        int expected = 2;

        // When
        int actual = carGroup.getLongestMileageCars().size();

        // Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}