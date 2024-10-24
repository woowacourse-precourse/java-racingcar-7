package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.randomnumber.RandomNumberGenerator;

class CarsTest {

    @DisplayName("자동차들을 받아서 Cars를 생성한다.")
    @Test
    void createCars() {
        //given
        List<Car> carList = List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("woni", new RandomNumberGenerator()),
                Car.from("jun", new RandomNumberGenerator())
        );

        //when
        Cars cars = Cars.from(carList);

        //then
        assertThat(cars).isEqualTo(Cars.from(carList));
    }

    @DisplayName("중복된 자동차가 있는 경우 예외를 발생한다.")
    @Test
    void duplicateCar() {
        //given
        List<Car> cars = List.of(
                Car.from("pobi", new RandomNumberGenerator()),
                Car.from("pobi", new RandomNumberGenerator())
        );

        //when //then
        assertThatThrownBy(() -> Cars.from(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}