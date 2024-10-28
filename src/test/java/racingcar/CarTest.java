package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void 전진하면_위치가_증가한다() {
        Car car = new Car("자동차1");
        car.moveForward();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 현재_위치를_보여준다() {
        Car car = new Car("자동차1");
        car.moveForward();
        assertThat(car.showPosition()).isEqualTo("-");
        car.moveForward();
        assertThat(car.showPosition()).isEqualTo("--");
    }


}
