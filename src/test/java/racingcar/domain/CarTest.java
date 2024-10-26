package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void car_moving_forward() {
        Car car = new Car("test");
        assertThat(car.toString()).isEqualTo("test : ");
        car.go();
        assertThat(car.toString()).isEqualTo("test : -");
        car.go();
        assertThat(car.toString()).isEqualTo("test : --");
    }
}