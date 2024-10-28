package racingcar.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NumberOfTrialsValidatorTest {
    private InputValidator numberOfTrialsValidator;

    @BeforeEach
    public void setUp() {
        numberOfTrialsValidator = new NumberOfTrialsValidator();
    }

    // 유효한 시도 횟수 입력 테스트
    @Test
    public void testValidNumberOfTrials() {
        String validNumberOfTrials = "5";
        assertDoesNotThrow(() -> numberOfTrialsValidator.validate(validNumberOfTrials));
    }

    // 숫자가 아닌 시도 횟수 입력에 대한 테스트
    @Test
    public void testInvalidNumberOfTrials_NotANumber() {
        String invalidNumberOfTrials = "five";
        assertThrows(IllegalArgumentException.class, () -> numberOfTrialsValidator.validate(invalidNumberOfTrials));
    }

    // 음수 시도 횟수 입력에 대한 테스트
    @Test
    public void testInvalidNumberOfTrials_NegativeNumber() {
        String invalidNumberOfTrials = "-3";
        assertThrows(IllegalArgumentException.class, () -> numberOfTrialsValidator.validate(invalidNumberOfTrials));
    }

    // 빈 입력에 대한 시도 횟수 입력 테스트
    @Test
    public void testInvalidNumberOfTrials_EmptyInput() {
        String invalidNumberOfTrials = "";
        assertThrows(IllegalArgumentException.class, () -> numberOfTrialsValidator.validate(invalidNumberOfTrials));
    }
}
