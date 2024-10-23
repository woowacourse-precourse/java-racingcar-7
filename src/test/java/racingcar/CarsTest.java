package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CarsTest {

    @DisplayName("우승한 자동차 목록을 찾는다.")
    @Test
    void getWinnerCars() {
        //given
        Car pobiCar = Car.from("pobi");
        Car helloCar = Car.from("hello");
        Car minCar = Car.from("min");
        Car naCar = Car.from("na");
        Cars cars = Cars.from(List.of(pobiCar, helloCar, minCar, naCar));
        //when
        List<Car> winners = cars.getWinnerCars();
        //then
        Assertions.assertThat(winners).extracting("name")
            .containsExactly("pobi", "hello", "min", "na");
    }

}