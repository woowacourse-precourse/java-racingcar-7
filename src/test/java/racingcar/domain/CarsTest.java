package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @Test
    @DisplayName("이름에 대한 예외사항이 없는 상황에서 초기 Cars 객체를 만든다.")
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
    @DisplayName("이름에 대한 예외상황에서 초기 Cars 객체를 만든다.")
    void makeOriginCarsHasException() {
        //given
        List<String> carNames = List.of("Uchae", "OhHyunji");

        //then
        assertThatThrownBy(() -> Cars.makeOriginCars(carNames)).isInstanceOf(IllegalArgumentException.class);
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