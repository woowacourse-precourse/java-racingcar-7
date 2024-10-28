package racingcar.factory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

class VehicleFactoryTest {

    @Test
    void createCars() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("woni");
        Car car3 = new Car("jun");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);

        String[] names = {"pobi", "woni","jun"};
        List<Car> result = VehicleFactory.createCars(names);

        Assertions.assertThat(result).isEqualTo(cars);
    }
}