package racingcar.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("hhj",0);

        assertThat("hhj").isEqualTo(car.getName());
        assertThat(0).isEqualTo(car.getLocation());
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("hhj",0);

        car.move();
        assertThat(1).isEqualTo(car.getLocation());
        car.move();
        assertThat(2).isEqualTo(car.getLocation());
    }
}
