package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 무작위_숫자가_4_이상() {
        Car car = new TestCar("pobi", true);

        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 무작위_숫자가_4_미만() {
        Car car = new TestCar("pobi", false);

        car.move();
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
