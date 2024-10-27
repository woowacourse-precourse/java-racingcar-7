package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CarTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("자동차가 전진한다면 위치가 1 증가한다")
        void testCarMovesForward() {
            // given
            Car car = new Car("pobi", 0);

            // when
            car.move();

            // then
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("자동차 이름이 null이면 IllegalArgumentException을 발생시킨다")
        void testCarNameNull() {
            // given & when & then
            assertThatThrownBy(() -> new Car(null, 0))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("자동차의 초기 위치가 음수이면 IllegalArgumentException을 발생시킨다")
        void testCarNegativePosition() {
            // when & then
            assertThatThrownBy(() -> new Car("pobi", -1))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
