package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 자동차_생성_테스트() {
        Car car = new Car("hhj",0);

        Assertions.assertThat("hhj").isEqualTo(car.getName());
        Assertions.assertThat(0).isEqualTo(car.getLocation());
    }

    @Test
    void 자동차_이동_테스트() {
        Car car = new Car("hhj",0);

        car.move();
        Assertions.assertThat(1).isEqualTo(car.getLocation());
        car.move();
        Assertions.assertThat(2).isEqualTo(car.getLocation());
    }
}
