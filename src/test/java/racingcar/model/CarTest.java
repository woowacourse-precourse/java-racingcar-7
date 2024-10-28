package racingcar.model;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void move_ShouldIncreasePosition_WhenRandomValueIsGreaterThanOrEqualTo4() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();

        car.move(4);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);

        car.move(9);
        assertThat(car.getPosition()).isEqualTo(initialPosition + 2);
    }

    @Test
    void move_ShouldNotIncreasePosition_WhenRandomValueIsLessThan4() {
        Car car = new Car("TestCar");
        int initialPosition = car.getPosition();

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(initialPosition);

        car.move(0);
        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }
}
