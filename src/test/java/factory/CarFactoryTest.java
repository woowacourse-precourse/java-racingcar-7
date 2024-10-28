package factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        carFactory = new CarFactory();
    }

    @Test
    void createCarsWithValidNames() {

        List<String> carNames = Arrays.asList("car1", "car2", "car3");

        List<Car> cars = carFactory.createCars(carNames);

        assertThat(cars).isNotNull().hasSize(3);
        assertThat(cars).extracting(Car::getName)
                .containsExactly("car1", "car2", "car3");
    }

}
