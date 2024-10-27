package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingWinnerTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private final CarRacingEnroll carRacingEnroll = new CarRacingEnroll();

    @Test
    public void 우승자_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni";
        CarGroup carGroup = carRacingEnroll.createCarGroup(carNames);
        assertRandomNumberInRangeTest(
                carGroup::accelerateAll,
                MOVING_FORWARD, STOP
        );
        CarRacingWinner carRacingWinner = new CarRacingWinner(carGroup);
        String expected = "최종 우승자 : pobi";

        //When
        String actual = carRacingWinner.getWinners();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }

    @Test
    public void 중복_우승자_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni";
        CarGroup carGroup = carRacingEnroll.createCarGroup(carNames);
        assertRandomNumberInRangeTest(
                carGroup::accelerateAll,
                MOVING_FORWARD, MOVING_FORWARD
        );
        CarRacingWinner carRacingWinner = new CarRacingWinner(carGroup);
        String expected = "최종 우승자 : pobi,woni";

        //When
        String actual = carRacingWinner.getWinners();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }
}