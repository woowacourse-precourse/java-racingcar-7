package racingcar.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름으로_자동차를_생성() {
        Car car = new Car("pobi");

        assertThat(car.getName())
                .isEqualTo("pobi");
    }
}
