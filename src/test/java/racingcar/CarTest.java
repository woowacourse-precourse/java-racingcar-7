package racingcar;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    void 자동차_이름을_가진다() {
        Car car = new Car("pobi");
        assertThat(car.getName()).isEqualTo("pobi");
    }
}
