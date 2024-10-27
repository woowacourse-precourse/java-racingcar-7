package racingcar.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    void create() {
        String carNames = "pobi,woni";

        List<Car> cars = CarFactory.create(carNames);

        assertThat(cars).hasSize(2);
        assertThat(cars).extracting(Car::getName).containsExactly("pobi", "woni");
    }

    @Test
    void Exception() {
        assertThrows(IllegalArgumentException.class, () -> CarFactory.create(null));
        assertThrows(IllegalArgumentException.class, () -> CarFactory.create(""));
        assertThrows(IllegalArgumentException.class, () -> CarFactory.create(" "));
        assertThrows(IllegalArgumentException.class, () -> CarFactory.create("pobi,woni,javaji"));
    }
}

