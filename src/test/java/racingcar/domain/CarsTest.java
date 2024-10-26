package racingcar.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarsTest {
    @Test
    void 전체_자동차_이동 () {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");

        Cars cars = new Cars(Arrays.asList(car1, car2, car3));
        cars.moveAll();

        List<Car> movedCars = cars.getCars();

        assertThat(movedCars)
                .extracting(Car::getPosition)
                .containsAnyOf(0, 1);
    }

}
