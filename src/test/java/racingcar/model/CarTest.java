package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static final int MOVING_MIN_VALUE = 4;

    @Test
    @DisplayName("자동차가 정상적으로 생성되는지 테스트")
    void testCarCreation() {
        // given
        String carName = "pobi";

        // when
        Car car = new Car(carName);

        // then
        assertThat(car.getName()).isEqualTo(carName);
        assertThat(car.getPosition()).isEqualTo(0);  // 초기 위치는 0이어야 함
    }

    @Test
    @DisplayName("자동차가 이동 조건을 충족하지 못할 때 위치가 변하지 않는지 테스트")
    void testCarDoesNotMoveWhenValueIsLessThanMin() {
        // given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();
        int value = MOVING_MIN_VALUE - 1;

        // when
        car.move(value);

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition);  // 위치는 변하지 않아야 함
    }

    @Test
    @DisplayName("자동차가 이동 조건을 충족할 때 위치가 증가하는지 테스트")
    void testCarMovesWhenValueIsGreaterThanOrEqualToMin() {
        // given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();
        int value = MOVING_MIN_VALUE;

        // when
        car.move(value);

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition + 1);  // 위치가 1만큼 증가해야 함
    }

    @Test
    @DisplayName("자동차가 여러 번 이동했을 때 위치가 올바르게 증가하는지 테스트")
    void testCarMovesMultipleTimes() {
        // given
        Car car = new Car("pobi");
        int initialPosition = car.getPosition();
        int moveValue = MOVING_MIN_VALUE;

        // when
        car.move(moveValue);
        car.move(moveValue);
        car.move(moveValue);

        // then
        assertThat(car.getPosition()).isEqualTo(initialPosition + 3);  // 3번 이동했으므로 위치가 3 증가해야 함
    }
}
