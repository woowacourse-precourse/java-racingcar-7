package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LapTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("시도 횟수가 양수일 때 Lap을 올바르게 생성하고 시도할 수 있는지 확인한다")
        void testValidLapCreation() {
            // given
            Lap lap = new Lap("5");

            // when & then
            assertThat(lap.isRemaining()).isTrue();
        }

        @Test
        @DisplayName("남은 시도가 있을 때 proceed 메서드를 호출하면 currentLap이 증가한다")
        void testProceedLap() {
            // given
            Lap lap = new Lap("3");

            // when
            lap.proceed();

            // then
            assertThat(lap.isRemaining()).isTrue();
        }

        @Test
        @DisplayName("모든 시도를 완료한 후 isRemaining이 false를 반환한다")
        void testCompleteAllLaps() {
            // given
            Lap lap = new Lap("2");

            // when
            lap.proceed();
            lap.proceed();

            // then
            assertThat(lap.isRemaining()).isFalse();
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("시도 횟수가 음수이면 IllegalArgumentException을 발생시킨다")
        void testNegativeAttempts() {
            // given
            String negativeAttempts = "-1";

            // when & then
            assertThatThrownBy(() -> new Lap(negativeAttempts))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("시도 횟수가 숫자가 아닌 경우 IllegalArgumentException을 발생시킨다")
        void testNonNumericAttempts() {
            // given
            String invalidAttempts = "test";

            // when & then
            assertThatThrownBy(() -> new Lap(invalidAttempts))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
