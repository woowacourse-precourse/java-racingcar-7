package racingcar.model.game.position;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("위치 집합 테스트")
class PositionsTest {

    @Nested
    @DisplayName("생성 테스트")
    class createTest {
        @Test
        @DisplayName("위치 집합을 생성한다")
        void 성공_생성() {
            // Given

            // When & Then
            assertThatCode(() -> {
                new Positions(Collections.emptyList());
            }).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("깊은 복사로 생성한다")
        void 성공_생성_깊은복사() {
            // Given
            Positions positions = new Positions(List.of(new Position(0)));

            // When
            Positions copied = positions.copy();

            // Then
            assertThat(copied).isNotSameAs(positions)
                    .isEqualTo(positions);
        }

    }

    @Nested
    @DisplayName("초기화 테스트")
    class initializeTest {
        @Test
        @DisplayName("위치 집합을 초기화한다")
        void 성공_초기화() {
            // Given
            int size = 1;

            // When
            Positions positions = Positions.createWithNewRound(size);

            // Then
            assertThat(positions).extracting("positions")
                    .isEqualTo(List.of(new Position(0)));
        }
    }

    @Nested
    @DisplayName("증가 테스트")
    class increaseTest {
        @Test
        @DisplayName("해당 인덱스의 위치를 증가시킨다")
        void 성공_위치증가_인덱스() {
            // Given
            Positions positions = new Positions(List.of(new Position(0)));

            // When
            positions.increase(0);

            // Then
            assertThat(positions).extracting("positions")
                    .isEqualTo(List.of(new Position(1)));
        }
    }

    @Nested
    @DisplayName("우승자 계산 테스트")
    class calculateWinnerTest {
        @Test
        @DisplayName("우승자를 계산한다")
        void calculateWinners() {
            // Given
            Positions positions = new Positions(List.of(new Position(1), new Position(2)));

            // When
            List<Integer> winners = positions.findWinnersIndices();

            // Then
            assertThat(winners).isEqualTo(List.of(1));
        }
    }
}
