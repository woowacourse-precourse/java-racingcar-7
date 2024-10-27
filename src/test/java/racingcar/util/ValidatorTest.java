package racingcar.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {
    @Test
    @DisplayName("유효한 자동차 이름 리스트는 예외가 발생하지 않아야 함")
    void testValidName() {
        List<String> validCarNames = Arrays.asList("CarA", "CarB");
        assertDoesNotThrow(() -> Validator.validateCarNames(validCarNames));
    }

    @Test
    @DisplayName("자동차가 2대 미만일 경우 예외 발생")
    void testCarCountValidation() {
        List<String> invalidCarNames = List.of("CarA");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidCarNames));
    }

    @Test
    @DisplayName("자동차 이름에 중복이 있을 경우 예외 발생")
    void testDuplicateNameValidation() {
        List<String> duplicateNames = Arrays.asList("CarA", "CarA");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(duplicateNames));
    }

    @Test
    @DisplayName("자동차 이름이 알파벳이 아닌 경우 예외 발생")
    void testNameFormatValidation() {
        List<String> invalidFormatNames = Arrays.asList("Car1", "Car@");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(invalidFormatNames));
    }

    @Test
    @DisplayName("자동차 이름이 5자 초과인 경우 예외 발생")
    void testNameLengthValidation() {
        List<String> longNames = Arrays.asList("CarABC", "CarDEFGH");
        assertThrows(IllegalArgumentException.class, () -> Validator.validateCarNames(longNames));
    }

    @Test
    @DisplayName("유효한 라운드 입력은 예외가 발생하지 않아야 함")
    void testValidRound() {
        assertDoesNotThrow(() -> Validator.validateRound("5"));
    }

    @Test
    @DisplayName("라운드 입력이 숫자가 아닐 경우 예외 발생")
    void testRoundIsNumericValidation() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateRound("abc"));
    }

    @Test
    @DisplayName("라운드 입력이 0 이하일 경우 예외 발생")
    void testRoundPositiveValidation() {
        assertThrows(IllegalArgumentException.class, () -> Validator.validateRound("0"));
        assertThrows(IllegalArgumentException.class, () -> Validator.validateRound("-1"));
    }
}