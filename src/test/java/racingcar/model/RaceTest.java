package racingcar.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RaceTest {

    @Test
    void throwExceptionIfHasDuplicateCar() {
        List<Car> cars = List.of(new Car("A"), new Car("A"));

        Assertions.assertThatThrownBy(() -> new Race(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void throwExceptionIfHasNotEnoughCar() {
        List<Car> cars = List.of(new Car("A"));

        Assertions.assertThatThrownBy(() -> new Race(cars))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
