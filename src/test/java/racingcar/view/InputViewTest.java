package racingcar.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.Console;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.Mockito.*;

public class InputViewTest {

    @Test
    public void inputCarNames_ValidInput_ShouldReturnCarNames() {
        // Given
        String simulatedInput = "CarA, CarB, CarC";
        Console consoleMock = Mockito.mock(Console.class);
        when(consoleMock.readLine()).thenReturn(simulatedInput);

        // When
        String carNames = InputView.inputCarNames();

        // Then
        assertThat(carNames).isEqualTo(simulatedInput);
    }

    @Test
    public void inputAttemptCount_ValidInput_ShouldReturnAttemptCount() {
        // Given
        String simulatedInput = "3";
        Console consoleMock = Mockito.mock(Console.class);
        when(consoleMock.readLine()).thenReturn(simulatedInput);

        // When
        int attemptCount = InputView.inputAttemptCount();

        // Then
        assertThat(attemptCount).isEqualTo(3);
    }

    @Test
    public void inputAttemptCount_InvalidInput_ShouldThrowException() {
        // Given
        String simulatedInput = "abc";
        Console consoleMock = Mockito.mock(Console.class);
        when(consoleMock.readLine()).thenReturn(simulatedInput);

        // When & Then
        assertThatThrownBy(InputView::inputAttemptCount)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("시도 횟수는 숫자로 입력해야 합니다.");
    }
}