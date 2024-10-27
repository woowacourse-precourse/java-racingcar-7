package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class MoveTest {

    @DisplayName("자동차가 움직이지 않으면 위치는 0 이다.")
    @Test
    void moveFailTest() {
        // given
        Car car = new Car("car");

        // then
        assertThat(car.getMove() == 0).isTrue();
    }

    @DisplayName("자동차가 1회 움직이면 위치는 1 이다.")
    @Test
    void moveSuccessTest() {
        // given
        Car car = new Car("car");

        // when
        car.move();

        // then
        assertThat(car.getMove() == 1).isTrue();
    }

    @DisplayName("자동차가 위치와 다른 경우 false 이다.")
    @Test
    void moveSamePositionFailTest() {
        // given
        Car car = new Car("car");

        // when
        car.move();
        car.move();

        // then
        assertThat(car.getMove()==1).isFalse();
    }
}