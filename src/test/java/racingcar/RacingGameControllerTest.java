package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.controller.RacingGameController;
import racingcar.service.RacingGameService;
import racingcar.validation.InputValidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingGameControllerTest {
    private final RacingGameService racingGameService = new RacingGameService();
    private final RacingGameController racingGameController = new RacingGameController(racingGameService);



    @ParameterizedTest
    @ValueSource(strings = {"1", "5", "10"})
    void validateTryNumber_ValidInput_ShouldNotThrowException(String tryNumber) {
        assertDoesNotThrow(() -> InputValidator.validateTryNumber(tryNumber));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "abc", ""})
    void validateTryNumber_InvalidInput_ShouldThrowException(String tryNumber) {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.validateTryNumber(tryNumber));
    }
}
