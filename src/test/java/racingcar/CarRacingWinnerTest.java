package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.BrokenAccelerator;

class CarRacingWinnerTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    public void 우승자_테스트() throws Exception {
        //Given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("pobi"), new Car("woni")));
        assertRandomNumberInRangeTest(
                () -> {
                    carGroup.accelerateAll(new BrokenAccelerator());
                },
                MOVING_FORWARD, STOP
        );
        CarRacingWinner carRacingWinner = new CarRacingWinner(carGroup);
        String expected = "최종 우승자 : pobi";

        //When
        String actual = carRacingWinner.toString();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void 중복_우승자_테스트() throws Exception {
        //Given
        CarGroup carGroup = new CarGroup(Arrays.asList(new Car("pobi"), new Car("woni")));
        assertRandomNumberInRangeTest(
                () -> {
                    carGroup.accelerateAll(new BrokenAccelerator());
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
        CarRacingWinner carRacingWinner = new CarRacingWinner(carGroup);
        String expected = "최종 우승자 : pobi,woni";

        //When
        String actual = carRacingWinner.toString();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }
}