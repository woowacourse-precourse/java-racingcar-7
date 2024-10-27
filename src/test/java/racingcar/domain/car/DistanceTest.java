package racingcar.domain.car;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


@DisplayName("자동차 거리(Distance) 유스케이스")
class DistanceTest {

    @Nested
    @DisplayName("생성 메서드")
    class 생성_메서드 {
        @DisplayName("생성_성공")
        @Test
        void 생성_성공() {
            // given
            final int distance = 10;

            // expect
            assertThatCode(() -> Distance.of(distance))
                    .doesNotThrowAnyException();
        }

        @DisplayName("초기 거리(0)_성공")
        @Test
        void 생성_성공_0으로() {
            // expect
            assertThatCode(() -> Distance.zero())
                    .doesNotThrowAnyException();
        }

        @DisplayName("초기 거리(0) 생성 성공")
        @Test
        void zero로_초기화_생성_성공() {
            // when
            int distanceValue = Distance.zero().getValue();

            // then
            Assertions.assertThat(distanceValue).isEqualTo(0);
        }
    }

    @Nested
    @DisplayName("거리 더하기 메서드")
    class 이동 {
        @DisplayName("두 거리 더하기 성공")
        @Test
        void 두_거리_더하기_성공() {
            // Given
            Distance distance1 = Distance.of(2);
            Distance distance2 = Distance.of(3);

            // When
            Distance sum = distance1.add(distance2);

            // Then
            assertThat(sum.getValue()).isEqualTo(5);

        }
    }
}