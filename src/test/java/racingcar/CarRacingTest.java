package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static racingcar.CarTest.createTestCar;

import java.util.Iterator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 자동차_경주_테스트() throws Exception {
        //Given
        CarGroup carGroup = new CarGroup(List.of(createTestCar("pobi"), createTestCar("woni")));
        CarRacing carRacing = new CarRacing(carGroup, 2);
        List<String> expected = List.of("pobi : -\nwoni : ", "pobi : --\nwoni : ", "최종 우승자 : pobi");

        //When, Then
        assertRandomNumberInRangeTest(
                () -> {
                    Iterator<String> actual = carRacing.race().iterator();
                    for (String expectedItem : expected) {
                        Assertions.assertThat(actual.hasNext()).isTrue();
                        Assertions.assertThat(actual.next()).isEqualTo(expectedItem);
                    }
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }
}