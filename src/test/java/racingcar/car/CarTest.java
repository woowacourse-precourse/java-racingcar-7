package racingcar.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차는 입력된 이동거리가 4이상이면 그 값만큼 전진한다")
    void moveWhenValueIsMoreOrEqualToFour() {
        // given
        Car car = Car.from("test");
        int value = 4;
        int positionDelta = 1;

        // when
        car.tryMoveForward(value, positionDelta);

        // then
        assertThat(car.getPosition()).isEqualTo(1);

    }

    @Test
    @DisplayName("자동차는 입력된 이동거리가 4보다 작다면 전진하지 않는다")
    void stopWhenValueIsLessThanFour() {
        // given
        Car car = Car.from("test");
        int value = 3;
        int positionDelta = 1;

        // when
        car.tryMoveForward(value, positionDelta);

        // then
        assertThat(car.getPosition()).isEqualTo(0);

    }
}