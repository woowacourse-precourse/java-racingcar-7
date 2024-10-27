package racingcar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.io.Validator;

import java.util.List;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    @DisplayName("중복된 값이 있는 경우 예외를 던진다")
    void validateDuplicates() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateDuplicates(List.of("jiwon","happy", "jiwon")));
    }

    @Test
    @DisplayName("길이가 5이하인 경우 예외를 던지지 않는다")
    void validateCarNameLength() {
        Assertions.assertDoesNotThrow(() -> validator.validateCarNameLength("abcde"));
        Assertions.assertDoesNotThrow(() -> validator.validateCarNameLength("12345"));
        Assertions.assertDoesNotThrow(() -> validator.validateCarNameLength("!@#$%"));
        Assertions.assertDoesNotThrow(() -> validator.validateCarNameLength("1.2.3"));
    }

    @Test
    @DisplayName("길이가 5를 초과하는 경우 예외를 던진다")
    void validateCarNameLength_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateCarNameLength("LeeJiwon"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateCarNameLength("h1h2h3"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateCarNameLength("      "));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateCarNameLength("123456"));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateCarNameLength("!@#$%^"));
    }

    @Test
    @DisplayName("입력이 들어온 경우 예외를 던지지 않는다")
    void validateNotEmptyName() {
        Assertions.assertDoesNotThrow(() -> validator.validateNotEmptyName("ljw"));
    }

    @Test
    @DisplayName("입력이 비어있는 경우 예외를 던진다")
    void validateNotEmptyName_예외() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateNotEmptyName(null));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateNotEmptyName(" "));
        Assertions.assertThrows(IllegalArgumentException.class, () -> validator.validateNotEmptyName(""));
    }
}