package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.CarNameValidator;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNameValidatorTest {
    public final CarNameValidator validator = new CarNameValidator();

    @DisplayName("유효한 이름 테스트")
    @Test
    public void testValidCarName() {
        // 유효한 이름에 대해서는 예외가 발생하지 않아야 함
        validator.validate("Car1"); // 유효한 이름
        validator.validate("ABCD"); // 유효한 이름
        validator.validate("12345"); // 유효한 이름
    }

    @DisplayName("길이가 6자 이상")
    @Test
    public void testInvalidCarNameTooLong() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("CarName")); // 길이가 6자 이상
    }

    @DisplayName("빈 문자열")
    @Test
    public void testInvalidCarNameEmpty() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("")); // 빈 문자열
    }

    @DisplayName("null")
    @Test
    public void testInvalidCarNameNull() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate(null)); // null
    }

    @DisplayName("공백만 있는 문자열")
    @Test
    public void testInvalidCarNameWhitespace() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("    ")); // 공백만 있는 문자열
    }
}
