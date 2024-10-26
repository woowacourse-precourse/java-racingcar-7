package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    private final CarFactory carFactory = CarFactory.getInstance();

    @Test
    void CarFactory_생성() {
        assertThat(carFactory).isEqualTo(CarFactory.getInstance());
    }

    @Test
    void Cars_생성() {
        List<Car> carList = List.of(new Car("pobi"), new Car("nana"));
        assertThat(carFactory.createCars("pobi,nana")).isEqualTo(new Cars(carList));
    }
}
