package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @Test
    void 자동차_이름_글자수_초과() {
        assertThatThrownBy(() -> new Car("toolongname"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름_유효() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 빈_이름_추가() {
        assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
