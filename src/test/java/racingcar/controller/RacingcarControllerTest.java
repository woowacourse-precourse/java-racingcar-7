package racingcar.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class RacingcarControllerTest {
    private RacingcarController controller;

    @BeforeEach
    public void setUp() {
        controller = new RacingcarController();
    }

    @Test
    public void playGame_ShouldRunWithoutErrors() {
        // Given
        String carNames = "CarA, CarB, CarC";
        int attemptCount = 3;

        // Mocking Input and Output
        when(InputView.inputCarNames()).thenReturn(carNames);
        when(InputView.inputAttemptCount()).thenReturn(attemptCount);

        // When
        controller.playGame();

        // Then
        List<Car> cars = controller.getCars();
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("CarA");
        assertThat(cars.get(1).getName()).isEqualTo("CarB");
        assertThat(cars.get(2).getName()).isEqualTo("CarC");
    }
}