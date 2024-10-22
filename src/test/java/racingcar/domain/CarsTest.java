package racingcar.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void makeOriginCars() {
        //given
        List<String> carNames = List.of("sumin", "boye");
        List<Car> expectAllCars = List.of(new Car("sumin", 0), new Car("boye", 0));

        //when
        Cars cars = Cars.makeOriginCars(carNames);

        //then
        Assertions.assertThat(cars.allCar()).isEqualTo(expectAllCars);
    }
}