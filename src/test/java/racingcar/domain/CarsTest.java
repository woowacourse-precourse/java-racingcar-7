package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @Test
    @DisplayName("Cars 객체를 생성한다.")
    void create() {
        // given
        Car car1 = new Car("cars1");
        Car car2 = new Car("cars2");
        List<Car> elements = List.of(car1, car2);

        // when
        Cars cars = new Cars(elements);

        // then
        assertThat(cars).isNotNull();
    }

    @Test
    @DisplayName("모든 Car 요소들의 위치를 이동한다.")
    void moveCars() {
        // given
        Car car1 = new Car("cars1");
        Car car2 = new Car("cars2");
        Cars cars = new Cars(List.of(car1, car2));

        // when
        cars.moveCars(new NumberGenerator() {
            @Override
            public int generateNumber() {
                return 4;
            }
        });

        // then
        assertThat(cars.getResult()).contains(car1.getResult());
        assertThat(cars.getResult()).contains(car2.getResult());
    }
}