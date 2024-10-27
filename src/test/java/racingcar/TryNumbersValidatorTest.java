package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumbersValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "2나", "$3"})
    void 시도횟수가_정수가_아닐때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            TryNumbersValidator.isNumeric(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "12", "23", "12321312"})
    void 시도횟수가_정수_일때(String userInput) {
        assertDoesNotThrow(() -> {
            TryNumbersValidator.isNumeric(userInput);
        });
    }

}