package racingcar.model.car;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarsTest {

    @Test
    void throwExceptionIfHasDuplicateCar() {
        List<Car> cars = List.of(new Car("A"), new Car("A"));

        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfHasNotEnoughCar() {
        List<Car> cars = List.of(new Car("A"));

        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
