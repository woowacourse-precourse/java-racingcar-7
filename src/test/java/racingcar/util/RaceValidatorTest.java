package racingcar.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.error.ErrorMessage;

public class RaceValidatorTest {

    private RaceValidator raceValidator;

    @BeforeEach
    void setUp() {
        raceValidator = new RaceValidator();
    }

    @Test
    @DisplayName("유효한 이동 시도 횟수 검사")
    void testCheckRaceCountWithValidCount() {
        // Arrange
        int raceCount = 5;

        // Act & Assert
        raceValidator.checkRaceCount(raceCount);
    }

    @Test
    @DisplayName("유효하지 않은 이동 시도 횟수(음수)일 시 예외 발생")
    void testCheckRaceCountWithNegativeCount() {
        // Arrange
        int raceCount = -1;

        // Act & Assert
        assertThatThrownBy(() -> raceValidator.checkRaceCount(raceCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 이동 시도 횟수(0)일 시 예외 발생")
    void testCheckRaceCountWithZeroCount() {
        // Arrange
        int raceCount = 0;

        // Act & Assert
        assertThatThrownBy(() -> raceValidator.checkRaceCount(raceCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
    }

    @Test
    @DisplayName("유효하지 않은 이동 시도 횟수(범위 초과)일 시 예외 발생")
    void testCheckRaceCountWithExceedingCount() {
        // Arrange
        int raceCount = 101;

        // Act & Assert
        assertThatThrownBy(() -> raceValidator.checkRaceCount(raceCount))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.INVALID_RACE_COUNT.getMessage());
    }
}
