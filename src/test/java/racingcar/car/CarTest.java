package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void blankNameTest() {
        assertThatThrownBy(() -> new Car("  ")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void nameLengthTest() {
        assertThatThrownBy(() -> new Car("Looong")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void moveTest() {
        Car car = new Car("test");

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void equalsTest() {
        Car car1 = new Car("test");
        Car car2 = new Car("test");

        assertThat(car1).isEqualTo(car2);
    }
}