package racingcar;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarsTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차", "레이싱카", "다섯글자다"})
    public void regist(String racingCarName) throws Exception {
        //given
        RacingCars racingCars = new RacingCars();
        RacingCar newRacingCar = new RacingCar(racingCarName);

        //when
        boolean isSuccess = racingCars.registRacingCar(newRacingCar);

        //then
        assertThat(isSuccess).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"자동차", "레이싱카"})
    public void registWithDuplicatedRacingCar(String racingCarName) throws Exception {
        //given
        RacingCars racingCars = new RacingCars();

        //when, then
        racingCars.registRacingCar(new RacingCar(racingCarName));
        assertThatThrownBy(() -> {
            racingCars.registRacingCar(new RacingCar(racingCarName));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"자동차", "레이싱카"})
    public void toStringRacingCars(String racingCarName) throws Exception {
        //given
        RacingCars racingCars = new RacingCars();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 3; i++) {
            String newName = racingCarName + i;
            racingCars.registRacingCar(new RacingCar(newName));
            sb.append(newName).append(" : \n");
        }
        String expected = sb.toString();

        //when
        String racingCarsString = racingCars.toString();

        //then
        assertThat(racingCarsString).isEqualTo(expected);
    }


}