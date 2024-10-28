package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    private static final String RACING_CAR_NAME = "yoni";
    private static final int START_POSITION = 1;

    @DisplayName("자동차 이름을 중복으로 사용할 수 없습니다.")
    @Test
    void validateDuplicateRacingCarNames() throws Exception{
        //given
        RacingCar car = new RacingCar(RACING_CAR_NAME, START_POSITION);
        List<RacingCar> cars = List.of(car, car);
        //when //then
        Assertions.assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름을 중복으로 사용할 수 없습니다.");
    }

    @DisplayName("자동차 경주를 하기위해 자동차는 최소 2대이상 생성해야 한다.")
    @Test
    void validateMinimumCarCount() throws Exception{
        //given
        RacingCar car = new RacingCar(RACING_CAR_NAME, START_POSITION);
        List<RacingCar> cars = List.of(car);
        //when //then
        Assertions.assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 경주를 위해서는 최소 2대 이상의 자동차를 만들어야 합니다.");
    }
}