package racingcar.model.game.position;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("위치 테스트")
class PositionTest {

    @Nested
    @DisplayName("생성 테스트")
    class createTest {
        @Test
        @DisplayName("생성자로 위치를 생성한다")
        void 성공_생성() {
            // Given

            // When
            Position position = new Position(0);

            // Then
            assertThat(position).isEqualTo(new Position(0));
        }
    }

    @Nested
    @DisplayName("증가 테스트")
    class increaseTest {
        @Test
        @DisplayName("위치를 1 증가시킨다")
        void 성공_증가() {
            // Given
            Position position = new Position(0);

            // When
            position.increase();

            // Then
            assertThat(position.position()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("값 비교 테스트")
    class ValueTest {
        @Test
        @DisplayName("같은 값을 가지는지 비교한다")
        void 성공_값비교() {
            // Given
            Position position = new Position(0);

            // When & Then
            assertThat(position.is(0)).isTrue();
        }
    }
}
