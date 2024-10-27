package racingcar.filter;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.common.exception.InvalidCommandException;
import racingcar.common.exception.NegativeIterationException;
import racingcar.dto.RaceRequest;

class RaceInputValidationFilterTest {
    private RaceInputValidationFilter filter;

    @BeforeEach
    void setUp() {
        filter = new RaceInputValidationFilter();
    }

    @Test
    @DisplayName("유효한 요청을 필터링해야 한다")
    void testValidRequest() {
        // Given
        RaceRequest request = new RaceRequest("Car1,Car2", 3);
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When
        filter.doFilter(request, chain);

        // Then
        assertDoesNotThrow(() -> filter.doFilter(request, chain), "예외가 발생하지 않아야 한다.");

    }

    @Test
    @DisplayName("유효하지 않은 커맨드로 InvalidCommandException을 발생시켜야 한다")
    void testInvalidCommand() {
        // Given
        RaceRequest request = new RaceRequest("Car1,,Car2", 3); // Invalid command with consecutive commas
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When & Then
        assertThrows(InvalidCommandException.class, () -> filter.doFilter(request, chain),
                "InvalidCommandException이 발생해야 한다.");
    }

    @Test
    @DisplayName("빈 커맨드로 InvalidCommandException을 발생시켜야 한다")
    void testEmptyCommand() {
        // Given
        RaceRequest request = new RaceRequest("", 3); // Empty command
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When & Then
        assertThrows(InvalidCommandException.class, () -> filter.doFilter(request, chain),
                "InvalidCommandException이 발생해야 한다.");
    }

    @Test
    @DisplayName("음수 반복 횟수로 NegativeIterationException을 발생시켜야 한다")
    void testNegativeIterations() {
        // Given
        RaceRequest request = new RaceRequest("Car1,Car2", -1); // Negative iterations
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When & Then
        assertThrows(NegativeIterationException.class, () -> filter.doFilter(request, chain),
                "NegativeIterationException이 발생해야 한다.");
    }

    @Test
    @DisplayName("0 반복 횟수로 정상적으로 처리되어야 한다")
    void testZeroIterations() {
        // Given
        RaceRequest request = new RaceRequest("Car1,Car2", 0); // Zero iterations
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When
        filter.doFilter(request, chain);

        // Then
        assertDoesNotThrow(() -> filter.doFilter(request, chain), "예외가 발생하지 않아야 한다.");
    }

    @Test
    @DisplayName("단일 자동차 커맨드로 정상적으로 처리되어야 한다")
    void testSingleCarCommand() {
        // Given
        RaceRequest request = new RaceRequest("Car1", 3); // Single car command
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When
        filter.doFilter(request, chain);

        // Then
        assertDoesNotThrow(() -> filter.doFilter(request, chain), "예외가 발생하지 않아야 한다.");
    }

    @Test
    @DisplayName("공백만 포함된 커맨드로 InvalidCommandException을 발생시켜야 한다")
    void testWhitespaceOnlyCommand() {
        // Given
        RaceRequest request = new RaceRequest("   ", 3); // Whitespace command
        RaceFilterChain chain = new RaceFilterChain(Collections.emptyList());

        // When & Then
        assertThrows(InvalidCommandException.class, () -> filter.doFilter(request, chain),
                "InvalidCommandException이 발생해야 한다.");
    }
}
