package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarsTest {
    @DisplayName("자동차 이름은 중복 사용 예외 확인")
    @Test
    void validateDuplicateRacingCarNames() throws Exception{
        //given
        String racingCarName = "yoni";
        RacingCar car = new RacingCar(racingCarName, 1);
        List<RacingCar> cars = List.of(car, car);
        //when //then
        Assertions.assertThatThrownBy(() -> new RacingCars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복으로 사용될 수 없습니다.");
    }
}