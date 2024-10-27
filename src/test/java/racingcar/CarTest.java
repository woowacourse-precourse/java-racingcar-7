package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    @Test
    void 자동차_이름_얻기_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_위치_얻기_테스트() {
        Car car = new Car("pobi");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차_전진_테스트() {
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();

        car.move();

        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
    }
}
