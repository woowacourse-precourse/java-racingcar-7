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
}
