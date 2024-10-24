package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    void makeOriginCars() {
        //given
        List<String> carNames = List.of("sumin", "boye");
        List<Car> expectAllCarList = List.of(new Car("sumin", 0), new Car("boye", 0));
        Cars expectAllCar = new Cars(expectAllCarList);

        //when
        Cars allCar = Cars.makeOriginCars(carNames);

        //then
        assertThat(allCar).isEqualTo(expectAllCar);
    }

    @Test
    void findLongestDistance() {
        //given
        Cars cars = new Cars(List.of(new Car("sumin", 5), new Car("boye", 4)));
        int expectLongestDistance = 5;

        //when
        int longestDistance = cars.findLongestDistance();

        //then
        assertThat(longestDistance).isEqualTo(expectLongestDistance);
    }
}