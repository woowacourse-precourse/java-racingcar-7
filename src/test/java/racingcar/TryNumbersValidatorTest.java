package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TryNumbersValidatorTest {
    private TryNumbersValidator tryNumbersValidator;

    @BeforeEach
    void setUp() {
        this.tryNumbersValidator = new TryNumbersValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1a", "2나", "$3"})
    void 시도횟수가_정수가_아닐때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            tryNumbersValidator.validateNumeric(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3", "-123"})
    void 시도횟수가_음수일때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            tryNumbersValidator.validateNumeric(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"111", "12", "23", "12321312"})
    void 시도횟수가_정수_일때(String userInput) {
        assertDoesNotThrow(() -> {
            tryNumbersValidator.validateNumeric(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "    ", "      "})
    void 시도횟수가_공백일때(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> {
            tryNumbersValidator.validateNumeric(userInput);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "23", "45"})
    void 시도횟수가_공백이_아닐때(String userInput) {
        assertDoesNotThrow(() -> {
            tryNumbersValidator.validateNumeric(userInput);
        });
    }
}

