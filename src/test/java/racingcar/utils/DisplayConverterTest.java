package racingcar.utils;

import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarDto;
import racingcar.dto.RoundResult;
import racingcar.dto.Winners;

class DisplayConverterTest {

    @DisplayName("라운드 결과가 올바른 형식으로 변환된다")
    @Test
    void 라운드_결과_변환() {
        //given
        CarDto carDto1 = new CarDto("car1", 4);
        CarDto carDto2 = new CarDto("car2", 1);
        CarDto carDto3 = new CarDto("car3", 2);
        RoundResult roundResult = new RoundResult(Arrays.asList(carDto1, carDto2, carDto3));

        //when
        String roundResultMessage = DisplayConverter.convertRoundResult(roundResult);
        String expectedResult = "car1 : ----\n" +
                "car2 : -\n" +
                "car3 : --";

        //then
        Assertions.assertThat(roundResultMessage).isEqualTo(expectedResult);
    }

    @DisplayName("우승자가 올바른 형식으로 변환된다")
    @Test
    void 우승자_변환() {
        //given
        CarDto carDto1 = new CarDto("car1", 4);
        CarDto carDto2 = new CarDto("car2", 1);
        CarDto carDto3 = new CarDto("car3", 2);
        Winners winners = new Winners(Arrays.asList(carDto1, carDto2, carDto3));

        //when
        String winnersMessage = DisplayConverter.convertWinners(winners);
        String expectedResult = "car1, car2, car3";

        //then
        Assertions.assertThat(winnersMessage).isEqualTo(expectedResult);
    }
}
