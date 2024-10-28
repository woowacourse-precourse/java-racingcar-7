package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.constant.AppConstants;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @DisplayName("자동차는 초기 포지션을 0으로 가진다")
    @Test
    void carInitialPositionIsZero() {
        Car car = new Car("car1");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("자동차 객체는 이름을 갖는다")
    @Test
    void carHasName() {
        Car car = new Car("car1");
        assertThat(car.getName()).isEqualTo("car1");
    }

    @DisplayName("자동차가 이동 조건을 충족하면 포지션이 증가한다")
    @Test
    void carMovesForwardWhenConditionIsMet() {
        Car car = new Car("car1");
        car.move(AppConstants.MOVE_THRESHOLD);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차가 이동 조건을 충족하지 못하면 포지션이 유지된다")
    @Test
    void carDoesNotMoveWhenConditionIsNotMet() {
        Car car = new Car("car1");
        car.move(AppConstants.MOVE_THRESHOLD - 1);
        assertThat(car.getPosition()).isEqualTo(0);
    }
}
