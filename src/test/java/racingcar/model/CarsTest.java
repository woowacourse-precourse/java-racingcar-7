package racingcar.model;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
        assertThat(winners).extracting("name")
            .containsExactly("pobi", "hello", "min", "na");
    }

    @DisplayName("자동차들에게 이동 명령을 내린다.")
    @Test
    void moveCars() {
        //given
        Car pobiCar = Car.from("pobi");
        Car helloCar = Car.from("hello");
        Cars cars = Cars.from(List.of(pobiCar, helloCar));
        //when
        List<Car> movedCars = cars.move(() -> 4);
        //then
        assertThat(movedCars).extracting("name", "position")
            .containsExactly(
                Tuple.tuple("pobi", 1),
                Tuple.tuple("hello", 1)
            );
    }

    @DisplayName("자동차들에게 이동 명령을 내린다.")
    @Test
    void moveCars2() {
        //given
        Car pobiCar = Car.from("pobi");
        Car helloCar = Car.from("hello");
        Cars cars = Cars.from(List.of(pobiCar, helloCar));
        //when
        List<Car> movedCars = cars.move(() -> 3);
        //then
        assertThat(movedCars).extracting("name", "position")
            .containsExactly(
                Tuple.tuple("pobi", 0),
                Tuple.tuple("hello", 0)
            );
    }

}