package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DisplayConverterTest {

    @DisplayName("한 라운드의 결과가 알맞은 형식으로 반환")
    @Test
    void convertRoundResult() {
        //given
        CarDto carDto1 = new CarDto("car1",4);
        CarDto carDto2 = new CarDto("car2",1);
        CarDto carDto3 = new CarDto("car3",2);
        RoundResult roundResult = new RoundResult(Arrays.asList(carDto1,carDto2,carDto3));

        //when
        String roundResultMessage = DisplayConverter.convertRoundResult(roundResult);
        String expectedResult = "car1 : 4\n" +
                "car2 : 1\n" +
                "car3 : 2";

        //then
        Assertions.assertThat(roundResultMessage).isEqualTo(expectedResult);
    }

    @DisplayName("우승자가 알맞은 형식으로 반환")
    @Test
    void convertWinners() {
        //given
        Winners winners = new Winners(Arrays.asList("car1","car2","car3"));

        //when
        String winnersMessage = DisplayConverter.convertWinners(winners);
        String expectedResult = "car1, car2, car3";

        //then
        Assertions.assertThat(winnersMessage).isEqualTo(expectedResult);
    }
}