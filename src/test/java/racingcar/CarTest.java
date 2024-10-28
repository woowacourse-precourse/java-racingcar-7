package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    Car car;

    @BeforeEach
    void setup() {
        car = new Car("pobi");
    }

    @Test
    void 거리이동_테스트() {
        car.updateDistance();
        int result = car.getDistance();
        assertThat(result)
                .isEqualTo(1);
    }
}
