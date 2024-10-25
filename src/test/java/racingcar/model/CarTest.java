package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.controller.strategy.MoveStrategy;
import racingcar.controller.strategy.mock.MockMoveStrategy;

class CarTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("자동차가 전진할 수 있을 때 위치가 1 증가한다")
        void testCarMovesForward() {
            // given
            MoveStrategy moveStrategy = new MockMoveStrategy(true);
            Car car = new Car("pobi", moveStrategy, 0);

            // when
            car.attemptMove();

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }

        @Test
        @DisplayName("자동차가 전진할 수 없을 때 위치가 그대로 유지된다")
        void testCarDoesNotMove() {
            // given
            MoveStrategy moveStrategy = new MockMoveStrategy(false);
            Car car = new Car("pobi", moveStrategy, 0);

            // when
            car.attemptMove();

            // then
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("자동차 이름이 null이면 IllegalArgumentException을 발생시킨다")
        void testCarNameNull() {
            // given & when & then
            assertThatThrownBy(() -> new Car(null, null, 0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("자동차의 초기 위치가 음수이면 IllegalArgumentException을 발생시킨다")
        void testCarNegativePosition() {
            // when & then
            assertThatThrownBy(() -> new Car("pobi", null, -1))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
