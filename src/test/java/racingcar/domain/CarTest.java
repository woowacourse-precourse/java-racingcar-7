package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 전진하는_차_확인() {
        Car oneCar = Car.of("raccoon");
        oneCar.moveCar(4);
        assertThat(oneCar.getCarDistance()).isEqualTo(1);
    }

    @Test
    void 멈춰있는_차_확인() {
        Car oneCar = Car.of("raccoon");
        oneCar.moveCar(3);
        assertThat(oneCar.getCarDistance()).isEqualTo(0);
    }
}