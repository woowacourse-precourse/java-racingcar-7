package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingWinnerTest {

    @Test
    public void 중복_우승자_테스트() throws Exception {
        //Given
        String carNames = "pobi,woni,jun";
        CarGroup carGroup = new CarGroup(CarRacing.parseCarList(carNames));
        CarRacingWinner carRacingWinner = new CarRacingWinner(carGroup);
        String expected = "최종 우승자 : pobi,woni,jun";

        //When
        String actual = carRacingWinner.toString();

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);

    }
}