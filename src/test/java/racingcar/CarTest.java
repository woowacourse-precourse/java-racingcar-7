package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_이름_유효성_검사() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> new Car("자동차이름이길다"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_전진_검사() {
        Car car = new Car("pobi");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);

        car.move(3);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차_이름_확인() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
