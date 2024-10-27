package racingcar.test.serviceTest.factoryTest;

import org.junit.jupiter.api.Test;
import racingcar.service.factory.CarFactory;
import racingcar.service.factory.CarFactoryEmb;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarFactoryTestEmb implements CarFactoryTest {
    @Test
    public void testCreateCars() {
        CarFactory carFactory = new CarFactoryEmb();
        List<String> cars = new ArrayList<>();
        cars.add("A");
        cars.add("B");
        cars.add("C");
        assertThat(carFactory.createCars(cars).size()).isEqualTo(3);
    }
}
