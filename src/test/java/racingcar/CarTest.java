package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 이동_성공() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(4);  // 4 이상일 때 이동해야 함

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }

    @Test
    void 이동_실패() {
        Car car = new Car("test");
        int initialPosition = car.getPosition();
        car.move(3);  // 3 이하일 때는 이동하지 않음

        assertThat(car.getPosition()).isEqualTo(initialPosition);
    }
}
