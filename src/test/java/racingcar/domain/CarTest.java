package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi");
    }

    @Test
    void 전진하지_않는_경우() {
        car.move(0);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(1);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(2);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 전진하는_경우() {
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(2);
        car.move(6);
        assertThat(car.getPosition()).isEqualTo(3);
        car.move(7);
        assertThat(car.getPosition()).isEqualTo(4);
        car.move(8);
        assertThat(car.getPosition()).isEqualTo(5);
        car.move(9);
        assertThat(car.getPosition()).isEqualTo(6);
    }
}
