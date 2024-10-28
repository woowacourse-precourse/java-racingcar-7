package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("초기 Cars 객체를 만든다.")
    void make() {
        //given
        List<String> carNames = List.of("sumin", "boye");
        List<Car> expectAllCarList = List.of(new Car("sumin", 0), new Car("boye", 0));
        Cars expectAllCar = new Cars(expectAllCarList);

        //when
        Cars allCar = Cars.make(carNames);

        //then
        assertThat(allCar).isEqualTo(expectAllCar);
    }

    @Test
    @DisplayName("가장 긴 거리를 찾는다.")
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