package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 최소 이동값 이상일 때 이동하는지 테스트")
    void 자동차_이동_테스트() {
        Car car = new Car("pobi");

        car.move(4);
        assertThat(car.getDistance()).isEqualTo(4);

        car.move(5);
        assertThat(car.getDistance()).isEqualTo(9);
    }

    @Test
    @DisplayName("자동차가 최소 이동값 미만일 때 이동하지 않는지 테스트")
    void 이동값_미달시_이동안함_테스트() {
        Car car = new Car("pobi");

        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0); // assuming 4 is the minimum for movement
    }
}