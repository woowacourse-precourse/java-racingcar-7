package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 자동차_경주_테스트() throws Exception {
        //Given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("pobi"), new Car("woni")));
        CarRacing carRacing = new CarRacing(carGroup, 2);

        //When, Then
        assertRandomNumberInRangeTest(
                () -> {
                    List<String> actual = carRacing.race();
                    Assertions.assertThat(actual).contains("pobi : --\nwoni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
        );
    }
}