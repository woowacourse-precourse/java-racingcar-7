package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    void 자동차_이름을_가진다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }

    @Test
    void 자동차_이름_5글자_초과시_예외발생() {
        assertThatThrownBy(() -> new Car("javaji"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
