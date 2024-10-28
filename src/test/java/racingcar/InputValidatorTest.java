package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @DisplayName("validateName: Valid car names should return true")
    @Test
    void validateName_WithValidNames_ReturnsTrue() {
        InputValidator validator = new InputValidator("pobi,woni", "3");
        assertTrue(validator.validateName());
    }

    @DisplayName("validateName: Null input should throw IllegalArgumentException")
    @Test
    void validateName_WithNullInput_ThrowsException() {
        InputValidator validator = new InputValidator(null, "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateName());
    }

    @DisplayName("validateName: Empty input should throw IllegalArgumentException")
    @Test
    void validateName_WithEmptyInput_ThrowsException() {
        InputValidator validator = new InputValidator("", "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateName());
    }

    @DisplayName("validateName: Names longer than 5 characters should throw IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {
            "toolong,woni",
            "pobi,tooolong",
            "longname,shortname"
    })
    void validateName_WithLongNames_ThrowsException(String input) {
        InputValidator validator = new InputValidator(input, "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateName());
    }

    @DisplayName("validateName: Empty name in list should throw IllegalArgumentException")
    @Test
    void validateName_WithEmptyNameInList_ThrowsException() {
        InputValidator validator = new InputValidator("pobi,,woni", "3");
        assertThrows(IllegalArgumentException.class, () -> validator.validateName());
    }

    @DisplayName("validateNameRules: Valid name should return true")
    @Test
    void validateNameRules_WithValidName_ReturnsTrue() {
        InputValidator validator = new InputValidator("pobi", "3");
        assertTrue(validator.validateNameRules("pobi"));
    }

    @DisplayName("validateNameRules: Empty name should return false")
    @Test
    void validateNameRules_WithEmptyName_ReturnsFalse() {
        InputValidator validator = new InputValidator("pobi", "3");
        assertFalse(validator.validateNameRules(""));
    }

    @DisplayName("validateNameRules: Name longer than 5 characters should return false")
    @Test
    void validateNameRules_WithLongName_ReturnsFalse() {
        InputValidator validator = new InputValidator("pobi", "3");
        assertFalse(validator.validateNameRules("toolong"));
    }

    @DisplayName("validateRounds: Valid number should return true")
    @Test
    void validateRounds_WithValidNumber_ReturnsTrue() {
        InputValidator validator = new InputValidator("pobi", "3");
        assertTrue(validator.validateRounds());
    }

    @DisplayName("validateRounds: Null input should throw IllegalArgumentException")
    @Test
    void validateRounds_WithNullInput_ThrowsException() {
        InputValidator validator = new InputValidator("pobi", null);
        assertThrows(IllegalArgumentException.class, () -> validator.validateRounds());
    }

    @DisplayName("validateRounds: Empty input should throw IllegalArgumentException")
    @Test
    void validateRounds_WithEmptyInput_ThrowsException() {
        InputValidator validator = new InputValidator("pobi", "");
        assertThrows(IllegalArgumentException.class, () -> validator.validateRounds());
    }

    @DisplayName("validateRounds: Non-numeric input should throw IllegalArgumentException")
    @Test
    void validateRounds_WithNonNumericInput_ThrowsException() {
        InputValidator validator = new InputValidator("pobi", "abc");
        assertThrows(IllegalArgumentException.class, () -> validator.validateRounds());
    }

    @DisplayName("validateRounds: Zero or negative number should throw IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-100"})
    void validateRounds_WithZeroOrNegative_ThrowsException(String input) {
        InputValidator validator = new InputValidator("pobi", input);
        assertThrows(IllegalArgumentException.class, () -> validator.validateRounds());
    }

    @DisplayName("Constructor should accept valid inputs")
    @Test
    void constructor_WithValidInputs_CreatesInstance() {
        assertDoesNotThrow(() -> new InputValidator("pobi,woni", "3"));
    }

    @DisplayName("Multiple valid car names should be accepted")
    @Test
    void validateName_WithMultipleValidNames_ReturnsTrue() {
        InputValidator validator = new InputValidator("pobi,woni,jun", "3");
        assertTrue(validator.validateName());
    }
}
