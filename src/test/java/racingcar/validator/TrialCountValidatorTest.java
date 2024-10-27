package racingcar.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TrialCountValidatorTest {
    private TrialCountValidator trialCountValidator;

    @BeforeEach
    void setup(){
        trialCountValidator = new TrialCountValidator();
    }
    @DisplayName("입력횟수가 빈칸이거나 공백일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    void validateNotBlank_throwsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> trialCountValidator.validateNotBlank(input));
    }

    @DisplayName("입력횟수는 양수로만 이루어져 있다.")
    @ParameterizedTest
    @ValueSource(strings = {"1", "123", "5", "10"})
    void validateNumeric_success(String input) {
        assertDoesNotThrow(() -> trialCountValidator.validateNumeric(input));
    }

    @DisplayName("입력횟수가 양수가 아닌 다른 숫자나 문자일 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"-123", "0", "abc", "01x", "012", "010"})
    void validateNumeric_throwsException(String input) {
        assertThrows(IllegalArgumentException.class, () -> trialCountValidator.validateNumeric(input));
    }
}