package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
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

    @Test
    public void findFurthestCars() throws Exception {
        //given
        RacingCar 자동차 = new RacingCar("자동차", 1);
        RacingCar 레이싱카 = new RacingCar("레이싱카", 2);
        List<RacingCar> racingCarList = List.of(자동차, 레이싱카);
        RacingCars racingCars = new RacingCars(racingCarList);

        //when
        List<String> furthestCars = racingCars.findFurthestCarsName();

        //then
        assertThat(furthestCars.size()).isEqualTo(1);
        assertThat(furthestCars.getFirst()).isEqualTo(레이싱카.getName());
    }

    @Test
    public void findFurthestCarsWithSameDistance() throws Exception {
        //given
        RacingCar 자동차 = new RacingCar("자동차", 1);
        RacingCar 레이싱카 = new RacingCar("레이싱카", 1);
        List<RacingCar> racingCarList = List.of(자동차, 레이싱카);
        RacingCars racingCars = new RacingCars(racingCarList);

        //when
        List<String> furthestCars = racingCars.findFurthestCarsName();

        //then
        assertThat(furthestCars.size()).isEqualTo(2);
        assertThat(furthestCars).contains(자동차.getName());
        assertThat(furthestCars).contains(레이싱카.getName());
    }

    @Test
    public void findFurthestCarsWithZeroDistance() throws Exception {
        //given
        RacingCar 자동차 = new RacingCar("자동차", 0);
        RacingCar 레이싱카 = new RacingCar("레이싱카", 0);
        List<RacingCar> racingCarList = List.of(자동차, 레이싱카);
        RacingCars racingCars = new RacingCars(racingCarList);

        //when
        List<String> furthestCars = racingCars.findFurthestCarsName();

        //then
        assertThat(furthestCars.size()).isEqualTo(2);
        assertThat(furthestCars).contains(자동차.getName());
        assertThat(furthestCars).contains(레이싱카.getName());
    }

}