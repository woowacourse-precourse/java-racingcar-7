package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void moveIfAboveThreshold_전진테스트(){
        Car car = new Car("coh");
        car.moveIfAboveThreshold(5);
        Assertions.assertThat(car.getPosition()).isEqualTo("-");
    }

    @Test
    void moveIfAboveThreshold_멈춤테스트() {
        Car car = new Car("pobi");
        car.moveIfAboveThreshold(3);
        Assertions.assertThat(car.getPosition()).isEqualTo("");
    }
}