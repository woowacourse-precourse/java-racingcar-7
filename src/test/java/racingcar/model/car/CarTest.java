package racingcar.model.car;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("자동차 테스트")
class CarTest {

    @Nested
    @DisplayName("이동할 때,")
    class moveTest {

        @Test
        @DisplayName("전략에 따라 움직인다")
        void 성공_이동_전략() {
            // Given
            Car car = new Car("pobi", () -> true);

            // When & Then
            assertThat(car.doesMove()).isTrue();
        }
    }
}
