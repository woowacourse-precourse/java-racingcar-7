package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    void 자동차_생성() {
        Car car = new Car("hwan2");
        assertThat(car).isNotNull();
    }

    @Test
    void 자동차_전진() {
        Car car = new Car("hwan2");
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_멈춤() {
        Car car = new Car("hwan2");
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}