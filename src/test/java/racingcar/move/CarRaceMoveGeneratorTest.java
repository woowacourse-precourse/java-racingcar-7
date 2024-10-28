package racingcar.move;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarRaceMoveGeneratorTest {

    @Test
    @DisplayName("숫자가기준보다크면 true 반환")
    void success_AboveStandard() {
        // Given
        CarRaceMoveConfig config = CarRaceMoveConfig.DEFAULT; // aboveStandard = 4
        RandomNumberGenerator rng = (start, end) -> 5;
        CarRaceMoveGenerator moveGenerator = new CarRaceMoveGenerator(config, rng);

        // When
        boolean result = moveGenerator.move();

        // Then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("숫자가기준보다작으면 false 반환")
    void success_BelowStandard() {
        // Given
        CarRaceMoveConfig config = CarRaceMoveConfig.DEFAULT; // aboveStandard = 4
        RandomNumberGenerator rng = (start, end) -> 3;
        CarRaceMoveGenerator moveGenerator = new CarRaceMoveGenerator(config, rng);

        // When
        boolean result = moveGenerator.move();

        // Then
        assertThat(result).isFalse();
    }
}